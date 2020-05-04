package com.phd.reception.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (Studentinfo)表实体类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@SuppressWarnings("serial")
@Data
public class Studentinfo extends Model<Studentinfo> {
    //学生id
    private Integer sid;
    //学生学号(账号)
    private String sno;
    //学生姓名
    private Object sname;
    //学生密码
    private Object spwd;
    //学生班级id(来获得班级名称)
    private Integer cid;
    //学生手机号
    private Object stel;
    //学生所在宿舍
    private Object sdor;
    //家长手机号
    private Object sptel;
    //学生所在学院(通过id来获得)
    private Integer coid;



    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.sid;
    }
    }