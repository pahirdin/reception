package com.phd.reception.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.phd.reception.entity.Schoolattendancedetails;

import java.util.Map;

/**
 * 上课考勤详情表(Schoolattendancedetails)表服务接口
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
public interface SchoolattendancedetailsService extends IService<Schoolattendancedetails> {

    Page<Map<String, Object>> getStudentAttendance(Long said, Integer page, Integer limit);

    Schoolattendancedetails queryBeanBySaidAndState(Integer sid,Long said);

    int updateStateBySaidAndCid(Long said, Integer sid, Object state);

    Page<Map<String, Object>> queryStudentAttendance(Integer sid, Integer state, Integer page, Integer limit);
}