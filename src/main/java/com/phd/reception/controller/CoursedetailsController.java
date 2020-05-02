package com.phd.reception.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.phd.reception.entity.Coursedetails;
import com.phd.reception.service.CoursedetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程详情表(Coursedetails)表控制层
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-02 11:47:30
 */
@Controller
public class CoursedetailsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CoursedetailsService coursedetailsService;

    @RequestMapping("/getMajorByCouid")
    public @ResponseBody List<Coursedetails> getMajor(Integer couid) {
        if(couid == null) {
            return null;
        }
        return this.coursedetailsService.getMajor(couid);
    }
}