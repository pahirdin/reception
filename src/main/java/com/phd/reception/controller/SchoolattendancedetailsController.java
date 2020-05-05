package com.phd.reception.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.phd.reception.entity.Admininfo;
import com.phd.reception.entity.ResultMap;
import com.phd.reception.entity.Schoolattendancedetails;
import com.phd.reception.entity.Studentinfo;
import com.phd.reception.service.CourseService;
import com.phd.reception.service.SchoolattendancedetailsService;
import com.phd.reception.service.StudentinfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 上课考勤详情表(Schoolattendancedetails)表控制层
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@Controller
public class SchoolattendancedetailsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SchoolattendancedetailsService schoolattendancedetailsService;
    @Resource
    private CourseService courseService;
    @Resource
    private StudentinfoService studentinfoService;

    @RequestMapping("/getStudentAttendance")
    @ResponseBody
    private ResultMap getStudentAttendance(HttpServletRequest request, Long timss, Integer page, Integer limit) {
        HttpSession session = request.getSession();
        Admininfo admin = (Admininfo) session.getAttribute("admin");
        if (admin == null) {
            ModelAndView mv = new ModelAndView();
            mv.setViewName("/login/login.html");
            return new ResultMap();
        }
        if (timss == null) {
            return new ResultMap();
        }
        Page<Map<String, Object>> mapPage = this.schoolattendancedetailsService.getStudentAttendance(timss, page, limit);
        ResultMap resultMap = new ResultMap(mapPage);
        List<Map<String, Object>> data = resultMap.getData();
        for (Map<String, Object> datum : data) {
            datum.put("couname", this.courseService.getCounameByCouid((Integer) datum.get("couid")));
            String sid = this.studentinfoService.getSnameBySid((Integer) datum.get("sid"));
            datum.put("sname", sid);
            datum.put("sadstatus", getStatusName(Integer.parseInt(String.valueOf(datum.get("sadstatus")))));
        }
        resultMap.setData(data);
        return resultMap;
    }

    private String getStatusName(Integer sadstatus) {
        return sadstatus == 0 ? "缺勤" : sadstatus == 1 ? "已签到" : "请假";
    }



    @RequestMapping("/signInQeCode")
    @ResponseBody
    public String signInQeCode(HttpServletRequest request, Long said){
        HttpSession session = request.getSession();
        Studentinfo student = (Studentinfo) session.getAttribute("student");
        if (student == null){
            return "/login/login.html";
        }
        Schoolattendancedetails schoolattendancedetails = this.schoolattendancedetailsService.queryBeanBySaidAndState(student.getSid(),said);
        if (schoolattendancedetails == null) {
            return "400";
        }else {
            if (1 == Integer.parseInt(String.valueOf(schoolattendancedetails.getSadstatus()))) {
                return "201";
            }else {
                int cont = this.schoolattendancedetailsService.updateStateBySaidAndCid(said,student.getSid(),1);
                return "200";
            }
        }
    }

    @RequestMapping("/queryStudentAttendance")
    @ResponseBody
    public ResultMap queryStudentAttendance(HttpServletRequest request,Integer state, Integer page, Integer limit) {
        HttpSession session = request.getSession();
        Studentinfo student = (Studentinfo) session.getAttribute("student");
        if (student == null) {
            ModelAndView mv = new ModelAndView();
            mv.setViewName("/login/login.html");
            return new ResultMap();
        }
        Page<Map<String, Object>> mapPage = this.schoolattendancedetailsService.queryStudentAttendance(student.getSid(),state,page,limit);
        ResultMap resultMap = new ResultMap(mapPage);
        List<Map<String, Object>> data = resultMap.getData();
        for (Map<String, Object> datum : data) {
            datum.put("couname", this.courseService.getCounameByCouid((Integer) datum.get("couid")));
            datum.put("sadstatus", getStatusName(Integer.parseInt(String.valueOf(datum.get("sadstatus")))));
        }
        resultMap.setData(data);
        return resultMap;
    }

}