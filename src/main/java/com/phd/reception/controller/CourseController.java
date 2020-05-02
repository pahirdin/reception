package com.phd.reception.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.phd.reception.service.CourseService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * 课程表(Course)表控制层
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@Controller
public class CourseController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CourseService courseService;


}