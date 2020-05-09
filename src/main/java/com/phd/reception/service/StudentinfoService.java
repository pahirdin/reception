package com.phd.reception.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.phd.reception.entity.Studentinfo;

import java.util.List;

/**
 * (Studentinfo)表服务接口
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
public interface StudentinfoService extends IService<Studentinfo> {

    Studentinfo loginCheckStudent(String ano, String apwd);

    String getSnameBySid(Integer sid);

    List<Studentinfo> queryListByCid(Integer cid);

    Integer queryClassesCount(Integer cid);

    List<Studentinfo> queryListByCouidAndWarnumm(Integer couid, Integer awarnumm);
}