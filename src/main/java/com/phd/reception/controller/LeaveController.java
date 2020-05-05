package com.phd.reception.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.phd.reception.entity.Leave;
import com.phd.reception.entity.ResultMap;
import com.phd.reception.entity.Studentinfo;
import com.phd.reception.service.LeaveService;
import com.phd.reception.utiles.Sequns;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * 请假条表(Leave)表控制层
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@Controller
public class LeaveController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private LeaveService leaveService;

    @RequestMapping("/queryLeaveList")
    @ResponseBody
    private ResultMap queryLeaveList(HttpServletRequest request, Integer state, Integer page, Integer limit) {
        HttpSession session = request.getSession();
        Studentinfo student = (Studentinfo) session.getAttribute("student");
        if (student == null) {
            ModelAndView mv = new ModelAndView();
            mv.setViewName("/login/login.html");
            return new ResultMap();
        }
        Page<Map<String, Object>> mapPage = this.leaveService.queryLeaveList(state,page,limit);
        ResultMap resultMap = new ResultMap(mapPage);
        List<Map<String, Object>> data = resultMap.getData();
        for (Map<String, Object> datum : data) {
            datum.put("lstatus", getStatusName(Integer.parseInt(String.valueOf(datum.get("lstatus")))));
        }
        resultMap.setData(data);
        return resultMap;

    }
    private String getStatusName(Integer sadstatus) {
        return sadstatus == 0 ? "待审批" : sadstatus == 1 ? "批准" : "拒绝";
    }

    @RequestMapping("/addLeave")
    @ResponseBody
    public String addLeave(HttpServletRequest request,String start,String end,String lcontent,Integer radio) {
        HttpSession session = request.getSession();
        Studentinfo student = (Studentinfo) session.getAttribute("student");
        if (student == null) {
            return "/login/login.html";
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Leave leave = new Leave();
        leave.setLid(Sequns.getRandomNickname(9));
        leave.setSid(student.getSid());
        leave.setLstime(LocalDateTime.parse(start,df));
        leave.setLetime(LocalDateTime.parse(end,df));
        leave.setLtype(radio);
        leave.setLcontent(lcontent);
        leave.setLstatus(0);
        this.leaveService.save(leave);
        return "200";
    }
}