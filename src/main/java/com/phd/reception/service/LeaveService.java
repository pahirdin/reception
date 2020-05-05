package com.phd.reception.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.phd.reception.entity.Leave;

import java.util.Map;

/**
 * 请假条表(Leave)表服务接口
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
public interface LeaveService extends IService<Leave> {

    Page<Map<String, Object>> queryLeaveList(Integer state, Integer page, Integer limit);
}