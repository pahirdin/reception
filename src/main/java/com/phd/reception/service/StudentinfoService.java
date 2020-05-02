package com.phd.reception.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.phd.reception.entity.Studentinfo;

/**
 * (Studentinfo)表服务接口
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
public interface StudentinfoService extends IService<Studentinfo> {

    Studentinfo loginCheckStudent(String ano, String apwd);
}