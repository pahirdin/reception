package com.phd.reception.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phd.reception.entity.Course;
import com.phd.reception.mapper.CourseMapper;
import com.phd.reception.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程表(Course)表服务实现类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@Service("courseService")
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Resource
    private CourseMapper courseMapper;
    @Override
    public List<Course> queryList(Integer aid) {
        QueryWrapper<Course> query = Wrappers.query();
        query.eq("AID", aid);
        return this.courseMapper.selectList(query);
    }

    @Override
    public String getCounameByCouid(Integer couid) {
        LambdaQueryWrapper<Course> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Course::getCouid, couid);
        return this.courseMapper.selectOne(queryWrapper).getCouname();
    }

    @Override
    public List<Integer> getCouidList(Integer aid) {
        return this.courseMapper.getCouidList(aid);
    }

}