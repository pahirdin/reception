package com.phd.reception.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phd.reception.entity.Coursedetails;
import com.phd.reception.mapper.CoursedetailsMapper;
import com.phd.reception.service.CoursedetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程详情表(Coursedetails)表服务实现类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-02 11:47:30
 */
@Service("coursedetailsService")
public class CoursedetailsServiceImpl extends ServiceImpl<CoursedetailsMapper, Coursedetails> implements CoursedetailsService {

    @Resource
    private CoursedetailsMapper coursedetailsMapper;
    @Override
    public List<Coursedetails> getMajor(Integer couid) {
        QueryWrapper<Coursedetails> query = Wrappers.query();
        query.apply("B.CID=A.CID")
                .eq("A.COUID", couid);
        return this.coursedetailsMapper.getMajor(query);
    }
}