package com.phd.reception.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.phd.reception.entity.Admininfo;
import com.phd.reception.entity.Course;
import com.phd.reception.entity.Result;
import com.phd.reception.entity.Schoolattendance;
import com.phd.reception.service.ClassesService;
import com.phd.reception.service.CourseService;
import com.phd.reception.service.SchoolattendanceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 上课考勤表(Schoolattendance)表控制层
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@Controller
public class SchoolattendanceController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SchoolattendanceService schoolattendanceService;

    @Resource
    private CourseService courseService;
    @Resource
    private ClassesService classesService;
//    @RequestMapping("/getSchoolattendance")
//    @ResponseBody
//    private Result<Schoolattendance> getSchoolattendance(HttpServletRequest request, Integer page, Integer limit) {
//        HttpSession session = request.getSession();
//        Admininfo admin = (Admininfo) session.getAttribute("admin");
//        if (admin == null) {
//            return null;
//        }
//        return new Result<>(this.schoolattendanceService.getSchoolattendance(page,limit,admin.getAid()));
//    }

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @return 所有数据
     */
    @RequestMapping("/getSchoolattendance")
    @ResponseBody
    public Result getSchoolattendance(HttpServletRequest request, Integer page, Integer limit) {
        HttpSession session = request.getSession();
        Admininfo admin = (Admininfo) session.getAttribute("admin");
        if (admin == null) {
            return null;
        }

        List<Course> courses = this.courseService.queryList(admin.getAid());
        List<Integer> courseList = courses.stream().map(Course::getCouid).collect(Collectors.toList());
        if (courseList.isEmpty()) {
            return new Result();
        }
        LambdaQueryWrapper<Schoolattendance> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.in(Schoolattendance::getCouid, courseList)
                .orderByDesc(Schoolattendance::getSatime);
        Page<Schoolattendance> page2 = this.schoolattendanceService.page(new Page<>(page,limit), queryWrapper);
        List<Schoolattendance> records = page2.getRecords();
        for (Schoolattendance schoolattendance : records) {
            schoolattendance.setCname(this.classesService.getClassesNameById(schoolattendance.getCid()));
            schoolattendance.setCouname(this.courseService.getCounameByCouid(schoolattendance.getCouid()));
        }
        return new Result(page2.setRecords(records));
    }


}