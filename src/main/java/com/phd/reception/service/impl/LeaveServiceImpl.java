package com.phd.reception.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phd.reception.entity.Leave;
import com.phd.reception.mapper.LeaveMapper;
import com.phd.reception.service.LeaveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 请假条表(Leave)表服务实现类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@Service("leaveService")
public class LeaveServiceImpl extends ServiceImpl<LeaveMapper, Leave> implements LeaveService {
    @Resource
    private LeaveMapper leaveMapper;
    @Override
    public Page<Map<String, Object>> queryLeaveList(Integer state, Integer page, Integer limit) {
        Page<Map<String, Object>> mapPage = new Page<>(page,limit);
        LambdaQueryWrapper<Leave> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(state != null, Leave::getLstatus, state)
        .orderByDesc(Leave::getLetime);
        return this.leaveMapper.selectMapsPage(mapPage, queryWrapper);
    }
}