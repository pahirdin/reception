package com.phd.reception.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phd.reception.entity.Adminmanageclasses;
import com.phd.reception.mapper.AdminmanageclassesMapper;
import com.phd.reception.service.AdminmanageclassesService;
import org.springframework.stereotype.Service;

/**
 * 辅导员管理班级表(Adminmanageclasses)表服务实现类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@Service("adminmanageclassesService")
public class AdminmanageclassesServiceImpl extends ServiceImpl<AdminmanageclassesMapper, Adminmanageclasses> implements AdminmanageclassesService {

}