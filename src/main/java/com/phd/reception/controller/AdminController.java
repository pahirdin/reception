package com.phd.reception.controller;

import com.phd.reception.entity.*;
import com.phd.reception.service.*;
import com.phd.reception.utiles.QrCodeUtils;
import org.joda.time.DateTimeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pahaied@asiainfo.com
 * @date 2020-05-02
 */
@Controller
public class AdminController {

    /**
     * 服务对象
     */
    @Resource
    private CourseService courseService;
    @Resource
    private SchoolattendanceService schoolattendanceService;
    @Resource
    private SchoolattendancedetailsService schoolattendancedetailsService;
    @Resource
    private StudentinfoService studentinfoService;
    @Resource
    private ClassesService classesService;
    @Resource
    private AdmininfoService admininfoService;


    @RequestMapping("/openQRcode")
    public String openQRcode(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Admininfo admin = (Admininfo) session.getAttribute("admin");
        if (admin == null) {
            return  "/login/login.html";
        }
        List<Course> course = this.courseService.queryList(admin.getAid());
        model.addAttribute("course", course);
        return "/admin/QRcode.html";
    }

    @RequestMapping("/queryAttendance")
    public String queryAttendance(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Admininfo admin = (Admininfo) session.getAttribute("admin");
        if (admin == null) {
            return  "/login/login.html";
        }
        List<Integer> couid = courseService.getCouidList(admin.getAid());
        List<Schoolattendance> tims = this.schoolattendanceService.queryThisTime(couid);
        model.addAttribute("tims", tims);
        return "/admin/queryAttendance.html";
    }



    private boolean checkAdminSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Admininfo admin = (Admininfo) session.getAttribute("admin");
        if (admin == null) {
            return true;
        }
        return false;
    }

    @RequestMapping("/createQrCode")
    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRED)
    public void createQrCode(HttpServletRequest request, HttpServletResponse response,Integer cid,Integer couid,String saaddress,Model model) {
        if(checkAdminSession(request)) {
            model.addAttribute("/login/login.html");
        }
        Schoolattendance schoolattendance = setSchoolattendanceBean(cid, couid, saaddress);
        this.schoolattendanceService.save(schoolattendance);
        Long said = schoolattendance.getSaid();
        List<Studentinfo> list = this.studentinfoService.queryListByCid(cid);
        List<Schoolattendancedetails> schoolattendancedetails = new ArrayList<>();
        for (Studentinfo studentinfo : list) {
            Schoolattendancedetails schoolattendancedetails1 = new Schoolattendancedetails();
            schoolattendancedetails1.setSaid(said);
            schoolattendancedetails1.setCouid(couid);
            schoolattendancedetails1.setSid(studentinfo.getSid());
            schoolattendancedetails1.setSadstatus(0);
            schoolattendancedetails.add(schoolattendancedetails1);
        }
        this.schoolattendancedetailsService.saveBatch(schoolattendancedetails);
        HttpSession session = request.getSession();
        session.setAttribute("said",said);
        StringBuffer url = request.getRequestURL();
        try {
            OutputStream os = response.getOutputStream();
            //从配置文件读取需要生成二维码的连接
//            String requestUrl = GraphUtils.getProperties("requestUrl");
            //requestUrl:需要生成二维码的连接，logoPath：内嵌图片的路径，os：响应输出流，needCompress:是否压缩内嵌的图片
            QrCodeUtils.encode("http://172.20.10.2:8081/getQrCode?said="+said, "/static/img/phon.png", os, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/cloesQrCode")
    public void cloesQrCode(HttpServletRequest request,Model model){
        if(checkAdminSession(request)) {
            model.addAttribute("/login/login.html");
        }
        HttpSession session = request.getSession();
        Long said = (Long) session.getAttribute("said");
        this.schoolattendanceService.cloesQrCode(said);
        Schoolattendance schoolattendance = this.schoolattendanceService.queryList(said);
        schoolattendance.setSanum(this.studentinfoService.queryClassesCount(schoolattendance.getCid()));
        schoolattendance.setSainum(this.schoolattendancedetailsService.querySainumBySaid(said));
        float sainum = schoolattendance.getSainum();
        float sanum = schoolattendance.getSanum();
        schoolattendance.setSarate((int) ((sainum / sanum)*100));
        this.schoolattendanceService.updateByCloesQrCode(schoolattendance);
        String counameByCouid = this.courseService.getCounameByCouid(schoolattendance.getCouid());
        String classesNameById = this.classesService.getClassesNameById(schoolattendance.getCid());
        Classes classes = this.classesService.queryClasesBycid(schoolattendance.getCid());
        Course course = this.courseService.queryListByCouid(schoolattendance.getCouid());
        Admininfo headmaster = this.admininfoService.queryListById(classes.getMasterid());
        Admininfo instructor = this.admininfoService.queryListById(classes.getInsid());
        Admininfo teacherInClass = this.admininfoService.queryListById(course.getAid());

        if (headmaster != null && headmaster.getAwarnumm() != null) {
            List<Studentinfo> studentinfos = this.studentinfoService.queryListByCouidAndWarnumm(schoolattendance.getCouid(), headmaster.getAwarnumm());
            if(!studentinfos.isEmpty()) {
                StringBuilder st = new StringBuilder();
                st.append("    "+headmaster.getAname()+" 老师您好、以下【"+classesNameById+"】班级学生【"+counameByCouid+"】课中缺勤次数以达到您的预警请注意查收。\n\n");
                for (Studentinfo studentinfo : studentinfos) {
                    st.append(studentinfo.getSname()).append("[" + studentinfo.getSno() + "]\n");
                }
                mailService.sendSimpleMailMessge(headmaster.getAemail(),"湖南工学院考勤管理系统",st.toString());
            }
        }
        if (instructor != null && instructor.getAwarnumm() != null) {
            List<Studentinfo> studentinfos = this.studentinfoService.queryListByCouidAndWarnumm(schoolattendance.getCouid(), instructor.getAwarnumm());
            if(!studentinfos.isEmpty()) {
                StringBuilder st = new StringBuilder();
                st.append("    "+instructor.getAname()+" 老师您好、以下【"+classesNameById+"】班级学生【"+counameByCouid+"】课中缺勤次数以达到您的预警请注意查收。\n\n");
                for (Studentinfo studentinfo : studentinfos) {
                    st.append(studentinfo.getSname()).append("[" + studentinfo.getSno() + "]\n");
                }
                mailService.sendSimpleMailMessge(instructor.getAemail(),"湖南工学院考勤管理系统",st.toString());
            }
        }
        if (teacherInClass != null && teacherInClass.getAwarnumm() != null) {
            List<Studentinfo> studentinfos = this.studentinfoService.queryListByCouidAndWarnumm(schoolattendance.getCouid(), teacherInClass.getAwarnumm());
            if(!studentinfos.isEmpty()) {
                StringBuilder st = new StringBuilder();
                st.append("    "+teacherInClass.getAname()+" 老师您好、以下【"+classesNameById+"】班级学生【"+counameByCouid+"】课中缺勤次数以达到您的预警请注意查收。\n\n");
                for (Studentinfo studentinfo : studentinfos) {
                    st.append(studentinfo.getSname()).append("[" + studentinfo.getSno() + "]\n");
                }
                mailService.sendSimpleMailMessge(teacherInClass.getAemail(),"湖南工学院考勤管理系统",st.toString());
            }
        }
    }

    private Schoolattendance setSchoolattendanceBean(Integer cid, Integer couid, String saaddress) {
        Schoolattendance schoolattendance = new Schoolattendance();
        long timeMillis = DateTimeUtils.currentTimeMillis();
        schoolattendance.setSaid(timeMillis);
        schoolattendance.setSatime(LocalDateTime.now().plusMinutes(6));
        schoolattendance.setCid(cid);
        schoolattendance.setCouid(couid);
        schoolattendance.setSaaddress(saaddress);
        return schoolattendance;
    }

    @Resource
    private MailService mailService;
    @RequestMapping("/test")
    public void test() {
        mailService.sendSimpleMailMessge("947925429@qq.com","测试邮箱","test content");
    }
}
