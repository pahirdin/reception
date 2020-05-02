package com.phd.reception.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phd.reception.entity.Major;
import com.phd.reception.mapper.MajorMapper;
import com.phd.reception.service.MajorService;
import org.springframework.stereotype.Service;

/**
 * (Major)表服务实现类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@Service("majorService")
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major> implements MajorService {

}