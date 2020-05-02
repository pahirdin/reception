package com.phd.reception.controller;

import com.phd.reception.entity.Studentinfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author pahaied@asiainfo.com
 * @date 2020-05-02
 */
@Controller
public class UserController {

    @RequestMapping("/getQrCode")
    public String getQrCode(HttpServletRequest request, Long said) {
        if (checkStudentSession(request)){
            return "/login/login.html";
        }
        return "/login/indexStu.html";
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
