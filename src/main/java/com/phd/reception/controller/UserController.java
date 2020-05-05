package com.phd.reception.controller;

import com.phd.reception.entity.Studentinfo;
import com.phd.reception.service.ClassesService;
import com.phd.reception.service.SchoolattendanceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author pahaied@asiainfo.com
 * @date 2020-05-02
 */
@Controller
public class UserController {
    @Resource
    private SchoolattendanceService schoolattendanceService;
    @Resource
    private ClassesService classesService;
    @RequestMapping("/getQrCode")
    public String getQrCode(HttpServletRequest request, Long said) {
        if (checkStudentSession(request)){
            return "/login/login.html";
        }
        Integer cid = schoolattendanceService.getCidBySaid(said);
        String couname = classesService.getClassesNameById(cid);
        request.setAttribute("couname",couname);
        request.setAttribute("said",said);
        return "/student/confirmQeCode.html";
    }
    @RequestMapping("/attendanceMgr")
    private String attendanceMgr(HttpServletRequest request) {
        if (checkStudentSession(request)){
            return "/login/login.html";
        }
        return "/student/attendanceMgr.html";
    }
    @RequestMapping("/leaveMgr")
    private String leaveMgr(HttpServletRequest request) {
        if (checkStudentSession(request)){
            return "/login/login.html";
        }
        return "/student/leaveMgr.html";
    }
    @RequestMapping("/openLeavehtml")
    private String openLeavehtml(HttpServletRequest request) {
        if (checkStudentSession(request)){
            return "/login/login.html";
        }
        return "/student/openLeavehtml.html";
    }

    private boolean checkStudentSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Studentinfo student = (Studentinfo) session.getAttribute("student");
        if (student == null) {
            return true;
        }
        return false;
    }
}
