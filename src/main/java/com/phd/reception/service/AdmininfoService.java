package com.phd.reception.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.phd.reception.entity.Admininfo;

import java.util.List;

/**
 * (Admininfo)表服务接口
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:46:07
 */
public interface AdmininfoService extends IService<Admininfo> {

    Admininfo loginCheckAdmin(String ano, String apwd);
}