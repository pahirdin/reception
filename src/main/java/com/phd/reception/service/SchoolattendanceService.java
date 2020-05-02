package com.phd.reception.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.phd.reception.entity.Schoolattendance;

import java.util.List;

/**
 * 上课考勤表(Schoolattendance)表服务接口
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
public interface SchoolattendanceService extends IService<Schoolattendance> {
    List<Schoolattendance> queryThisTime(List<Integer> couid);

//    Page<Schoolattendance> getSchoolattendance(Integer page, Integer limit, Integer aid);
}