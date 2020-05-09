package com.phd.reception.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.phd.reception.entity.Course;

import java.util.List;

/**
 * 课程表(Course)表服务接口
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
public interface CourseService extends IService<Course> {

    List<Course> queryList(String aid);

    String getCounameByCouid(Integer couid);

    List<Integer> getCouidList(String aid);

    Course queryListByCouid(Integer couid);
}