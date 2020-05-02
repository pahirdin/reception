package com.phd.reception.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phd.reception.entity.Schoolattendancedetails;
import com.phd.reception.mapper.SchoolattendancedetailsMapper;
import com.phd.reception.service.SchoolattendancedetailsService;
import org.springframework.stereotype.Service;

/**
 * 上课考勤详情表(Schoolattendancedetails)表服务实现类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@Service("schoolattendancedetailsService")
public class SchoolattendancedetailsServiceImpl extends ServiceImpl<SchoolattendancedetailsMapper, Schoolattendancedetails> implements SchoolattendancedetailsService {

}