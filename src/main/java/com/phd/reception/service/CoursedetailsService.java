package com.phd.reception.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.phd.reception.entity.Coursedetails;

import java.util.List;

/**
 * 课程详情表(Coursedetails)表服务接口
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-02 11:47:30
 */
public interface CoursedetailsService extends IService<Coursedetails> {

    List<Coursedetails> getMajor(Integer couid);
}