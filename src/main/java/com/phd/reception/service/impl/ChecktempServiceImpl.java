package com.phd.reception.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phd.reception.entity.Checktemp;
import com.phd.reception.mapper.ChecktempMapper;
import com.phd.reception.service.ChecktempService;
import org.springframework.stereotype.Service;

/**
 * (Checktemp)表服务实现类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@Service("checktempService")
public class ChecktempServiceImpl extends ServiceImpl<ChecktempMapper, Checktemp> implements ChecktempService {

}