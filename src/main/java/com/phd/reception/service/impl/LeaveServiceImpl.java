package com.phd.reception.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phd.reception.entity.Leave;
import com.phd.reception.mapper.LeaveMapper;
import com.phd.reception.service.LeaveService;
import org.springframework.stereotype.Service;

/**
 * 请假条表(Leave)表服务实现类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@Service("leaveService")
public class LeaveServiceImpl extends ServiceImpl<LeaveMapper, Leave> implements LeaveService {

}