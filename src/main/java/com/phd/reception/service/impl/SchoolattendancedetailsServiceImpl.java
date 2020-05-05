package com.phd.reception.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phd.reception.entity.Schoolattendancedetails;
import com.phd.reception.mapper.SchoolattendancedetailsMapper;
import com.phd.reception.service.SchoolattendancedetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * 上课考勤详情表(Schoolattendancedetails)表服务实现类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@Service("schoolattendancedetailsService")
public class SchoolattendancedetailsServiceImpl extends ServiceImpl<SchoolattendancedetailsMapper, Schoolattendancedetails> implements SchoolattendancedetailsService {

    @Resource
    private SchoolattendancedetailsMapper schoolattendancedetailsMapper;
    @Override
    public Page<Map<String, Object>> getStudentAttendance(Long said, Integer page, Integer limit) {
        Page<Map<String, Object>> mapPage = new Page<>(page,limit);
        LambdaQueryWrapper<Schoolattendancedetails> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Schoolattendancedetails::getSaid, said);
        return this.schoolattendancedetailsMapper.selectMapsPage(mapPage,queryWrapper);
    }

    @Override
    public Schoolattendancedetails queryBeanBySaidAndState(Integer sid,Long said) {
        LambdaQueryWrapper<Schoolattendancedetails> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Schoolattendancedetails::getSid, sid)
                .eq(Schoolattendancedetails::getSaid, said);
        return this.schoolattendancedetailsMapper.selectOne(queryWrapper);
    }

    @Override
    public int updateStateBySaidAndCid(Long said, Integer sid, Object state) {
        LambdaUpdateWrapper<Schoolattendancedetails> updateWrapper = Wrappers.lambdaUpdate();
        updateWrapper.eq(Schoolattendancedetails::getSaid, said)
                .eq(Schoolattendancedetails::getSid, sid)
                .set(Schoolattendancedetails::getSadstatus, state)
                .set(Schoolattendancedetails::getSadtime, LocalDateTime.now());
        return this.schoolattendancedetailsMapper.update(null, updateWrapper);
    }

    @Override
    public Page<Map<String, Object>> queryStudentAttendance(Integer sid, Integer state, Integer page, Integer limit) {
        Page<Map<String, Object>> mapPage = new Page<>(page,limit);

        LambdaQueryWrapper<Schoolattendancedetails> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Schoolattendancedetails::getSid, sid);
        if(state != null){
            queryWrapper.eq( Schoolattendancedetails::getSadstatus, state);
        }
        queryWrapper.orderByDesc(Schoolattendancedetails::getSadtime);
        return this.schoolattendancedetailsMapper.selectMapsPage(mapPage,queryWrapper);
    }

}