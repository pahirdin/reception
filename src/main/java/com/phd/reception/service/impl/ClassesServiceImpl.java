package com.phd.reception.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phd.reception.entity.Classes;
import com.phd.reception.mapper.ClassesMapper;
import com.phd.reception.service.ClassesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 班级表(Classes)表服务实现类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@Service("classesService")
public class ClassesServiceImpl extends ServiceImpl<ClassesMapper, Classes> implements ClassesService {

    @Resource
    private ClassesMapper classesMapper;
    @Override
    public String getClassesNameById(Integer cid) {
        return classesMapper.getClassesNameById(cid);
    }
}