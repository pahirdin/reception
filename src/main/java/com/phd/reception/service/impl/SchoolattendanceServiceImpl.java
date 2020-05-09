package com.phd.reception.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phd.reception.entity.Schoolattendance;
import com.phd.reception.mapper.ClassesMapper;
import com.phd.reception.mapper.CourseMapper;
import com.phd.reception.mapper.SchoolattendanceMapper;
import com.phd.reception.service.SchoolattendanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 上课考勤表(Schoolattendance)表服务实现类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@Service("schoolattendanceService")

public class SchoolattendanceServiceImpl extends ServiceImpl<SchoolattendanceMapper, Schoolattendance> implements SchoolattendanceService {
    @Resource
    private SchoolattendanceMapper schoolattendanceMapper;
    @Resource
    private CourseMapper courseMapper;
    @Resource
    private ClassesMapper classesMapper;

    @Override
    public List<Schoolattendance> queryThisTime(List<Integer> couid) {
        LambdaQueryWrapper<Schoolattendance> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.in(Schoolattendance::getCouid, couid)
                .orderByDesc(Schoolattendance::getSatime)
        .last(" LIMIT 10 OFFSET 0");
        return this.schoolattendanceMapper.selectList(queryWrapper);
    }

    @Override
    public Integer getCidBySaid(Long said) {
        LambdaQueryWrapper<Schoolattendance> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Schoolattendance::getSaid, said);
        return this.schoolattendanceMapper.selectOne(queryWrapper).getCid();
    }

    @Override
    public int cloesQrCode(Long said) {
        LambdaUpdateWrapper<Schoolattendance> updateWrapper = Wrappers.lambdaUpdate();
        updateWrapper.eq(Schoolattendance::getSaid, said);
        updateWrapper.set(Schoolattendance::getSatime, LocalDateTime.now());
        return this.schoolattendanceMapper.update(null, updateWrapper);
    }

    @Override
    public int updateByCloesQrCode(Schoolattendance schoolattendance) {
        LambdaUpdateWrapper<Schoolattendance> updateWrapper = Wrappers.lambdaUpdate();
        updateWrapper.eq(Schoolattendance::getSaid, schoolattendance.getSaid());
        updateWrapper.set(Schoolattendance::getSanum, schoolattendance.getSanum())
                .set(Schoolattendance::getSainum, schoolattendance.getSainum())
                .set(Schoolattendance::getSarate, schoolattendance.getSarate());

        return this.schoolattendanceMapper.update(null,updateWrapper);
    }

    @Override
    public Schoolattendance queryList(Long said) {
        LambdaQueryWrapper<Schoolattendance> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Schoolattendance::getSaid, said);
        return this.schoolattendanceMapper.selectOne(queryWrapper);
    }


//    @Override
//    public PageInfo<Schoolattendance> getSchoolattendance(Integer page, Integer limit, Integer aid) {
//        LambdaQueryWrapper<Course> query = Wrappers.lambdaQuery();
//        query.eq(Course::getAid, aid);
//        List<Course> courses = this.courseMapper.selectList(query);
//        List<Integer> courseList = courses.stream().map(p -> p.getCouid()).collect(Collectors.toList());
//        if (courseList.isEmpty()) {
//            return null;
//        }
//        page = page == null ? 1 : page;
//        limit = limit == null ? 10 : limit;
//        //在帮助类中传入分页参数
//        PageHelper.startPage(page, limit);
//        LambdaQueryWrapper<Schoolattendance> queryWrapper = Wrappers.lambdaQuery();
//        queryWrapper.in(Schoolattendance::getCouid, courseList);
//        List<Schoolattendance> schoolattendances = this.schoolattendanceMapper.selectList(queryWrapper);
//        for (Schoolattendance schoolattendance : schoolattendances) {
//            schoolattendance.setCname(this.classesMapper.getClassesNameById(schoolattendance.getCid()));
//            schoolattendance.setCouname(this.courseMapper.getCounameByCouid(schoolattendance.getCouid()));
//        }
//        return new PageInfo<>(schoolattendances);
//    }
}