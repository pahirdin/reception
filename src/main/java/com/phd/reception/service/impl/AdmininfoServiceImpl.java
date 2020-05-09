package com.phd.reception.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phd.reception.entity.Admininfo;
import com.phd.reception.mapper.AdmininfoMapper;
import com.phd.reception.service.AdmininfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * (Admininfo)表服务实现类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:46:07
 */
@Service("admininfoService")
public class AdmininfoServiceImpl extends ServiceImpl<AdmininfoMapper, Admininfo> implements AdmininfoService {

    @Autowired
    private AdmininfoMapper admininfoMapper;


    @Override
    public Admininfo loginCheckAdmin(String ano, String apwd) {
        QueryWrapper<Admininfo> query = Wrappers.query();
        query.eq("ANO", ano).eq("APWD", DigestUtils.md5DigestAsHex(apwd.getBytes()));
        return this.admininfoMapper.selectOne(query);
    }

    @Override
    public Admininfo queryListById(String aid) {
        LambdaQueryWrapper<Admininfo> query = Wrappers.lambdaQuery();
        query.eq(Admininfo::getAid, aid);
        return this.admininfoMapper.selectOne(query);
    }

}