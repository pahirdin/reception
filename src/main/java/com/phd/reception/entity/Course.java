package com.phd.reception.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * 课程表(Course)表实体类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@SuppressWarnings("serial")
public class Course extends Model<Course> {
    //课程id
    private Integer couid;
    //课程名称
    private String couname;
    //班级id
    private Integer aid;


    public Integer getCouid() {
        return couid;
    }

    public void setCouid(Integer couid) {
        this.couid = couid;
    }

    public String getCouname() {
        return couname;
    }

    public void setCouname(String couname) {
        this.couname = couname;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

}