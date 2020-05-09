package com.phd.reception.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phd.reception.entity.Studentinfo;
import com.phd.reception.mapper.StudentinfoMapper;
import com.phd.reception.service.StudentinfoService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Studentinfo)表服务实现类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@Service("studentinfoService")
public class StudentinfoServiceImpl extends ServiceImpl<StudentinfoMapper, Studentinfo> implements StudentinfoService {

    @Resource
    private StudentinfoMapper studentinfoMapper;
    @Override
    public Studentinfo loginCheckStudent(String ano, String apwd) {
        String ss = DigestUtils.md5DigestAsHex(apwd.getBytes());
        QueryWrapper<Studentinfo> query = Wrappers.query();
        query.eq("SNO", ano)
        .eq("SPWD",ss);
        return this.studentinfoMapper.selectOne(query);
    }

    @Override
    public String getSnameBySid(Integer sid) {
        LambdaQueryWrapper<Studentinfo> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Studentinfo::getSid,sid);
        return (String) this.studentinfoMapper.selectOne(queryWrapper).getSname();
    }

    @Override
    public List<Studentinfo> queryListByCid(Integer cid) {
        LambdaQueryWrapper<Studentinfo> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Studentinfo::getCid, cid);
        return this.studentinfoMapper.selectList(queryWrapper);
    }

    @Override
    public Integer queryClassesCount(Integer cid) {
        LambdaQueryWrapper<Studentinfo> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Studentinfo::getCid, cid);
        return this.studentinfoMapper.selectCount(queryWrapper);
    }

    @Override
    public List<Studentinfo> queryListByCouidAndWarnumm(Integer couid, Integer awarnumm) {
        return this.studentinfoMapper.queryListByCouidAndWarnumm(couid,awarnumm);
    }

}