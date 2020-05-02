package com.phd.reception.controller;

import com.phd.reception.entity.Admininfo;
import com.phd.reception.entity.Studentinfo;
import com.phd.reception.service.AdmininfoService;
import com.phd.reception.service.StudentinfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author pahaied
 * @date 2019/12/13 10:44
 */
@Controller
public class LoginController {

    @Resource
    private AdmininfoService admininfoService;
    @Resource
    private StudentinfoService studentinfoService;
    @RequestMapping("/login")
    public String login(){
        return "/login/login.html";
    }

    @RequestMapping("/logonStu")
    public String logon(HttpServletRequest request){
        if (checkStudentSession(request)){
            return "/login/login.html";
        }
        return "/login/indexStu.html";
    }

    @RequestMapping("/logonAdm")
    public String logonAdm(HttpServletRequest request){
        if (checkAdminSession(request)){
            return "/login/login.html";
        }
        return "/login/indexAdm.html";
    }

    @RequestMapping("/welcomeAdm")
    public String welcome(HttpServletRequest request){
        if (checkAdminSession(request)){
            return "/login/login.html";
        }
        return "/login/welcomeAdm.html";
    }



    @RequestMapping("/welcomeStu")
    public String welcomeStu(HttpServletRequest request){
        if (checkStudentSession(request)){
            return "/login/login.html";
        }
        return "/login/welcomeStu.html";
    }


    /**
     * 学生登陆
     * @return 返回错误或成功信息（200）
     */
    @RequestMapping("/loginStudent")
    @ResponseBody
    public String loginStudent(HttpServletRequest request,String ano, String apwd) {
        Studentinfo studentinfo = this.studentinfoService.loginCheckStudent(ano,apwd);
        if (null == studentinfo) {
            return "202";
        }
        HttpSession session = request.getSession();
        session.setAttribute("student",studentinfo);
        return "200";
    }

    /**
     * 管理员登陆
     * @return 返回错误或成功信息（200）
     */
    @RequestMapping("/loginAdmin")
    @ResponseBody
    public String loginAdmin(HttpServletRequest request,String ano,String apwd) {
        Admininfo admininfo = this.admininfoService.loginCheckAdmin(ano,apwd);
        if (null == admininfo) {
            return "202";
        }
        HttpSession session = request.getSession();
        session.setAttribute("admin",admininfo);
        return "200";
    }




    private boolean checkAdminSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Admininfo admin = (Admininfo) session.getAttribute("admin");
        if (admin == null) {
            return true;
        }
        return false;
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
