package com.phd.reception.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phd.reception.entity.Staticdata;
import com.phd.reception.mapper.StaticdataMapper;
import com.phd.reception.service.StaticdataService;
import org.springframework.stereotype.Service;

/**
 * (Staticdata)表服务实现类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@Service("staticdataService")
public class StaticdataServiceImpl extends ServiceImpl<StaticdataMapper, Staticdata> implements StaticdataService {

}