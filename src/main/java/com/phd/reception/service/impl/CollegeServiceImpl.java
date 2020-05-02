package com.phd.reception.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phd.reception.entity.College;
import com.phd.reception.mapper.CollegeMapper;
import com.phd.reception.service.CollegeService;
import org.springframework.stereotype.Service;

/**
 * (College)表服务实现类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@Service("collegeService")
public class CollegeServiceImpl extends ServiceImpl<CollegeMapper, College> implements CollegeService {

}