package com.phd.reception.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.phd.reception.entity.Classes;

/**
 * 班级表(Classes)表服务接口
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
public interface ClassesService extends IService<Classes> {

    String getClassesNameById(Integer cid);
}