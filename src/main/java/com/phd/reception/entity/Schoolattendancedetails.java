package com.phd.reception.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * 上课考勤详情表(Schoolattendancedetails)表实体类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@SuppressWarnings("serial")
public class Schoolattendancedetails extends Model<Schoolattendancedetails> {
    //考勤详情id
    private Integer sadid;
    //考勤id
    private Integer said;
    //课程id
    private Integer couid;
    //学生id
    private Integer sid;
    //学生是否签到(0未签到,缺勤 1已签到 2请假)
    private Object sadstatus;
    //学生签到时间
    private Object sadtime;
    //签到地点
    private String sadaddress;


    public Integer getSadid() {
        return sadid;
    }

    public void setSadid(Integer sadid) {
        this.sadid = sadid;
    }

    public Integer getSaid() {
        return said;
    }

    public void setSaid(Integer said) {
        this.said = said;
    }

    public Integer getCouid() {
        return couid;
    }

    public void setCouid(Integer couid) {
        this.couid = couid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Object getSadstatus() {
        return sadstatus;
    }

    public void setSadstatus(Object sadstatus) {
        this.sadstatus = sadstatus;
    }

    public Object getSadtime() {
        return sadtime;
    }

    public void setSadtime(Object sadtime) {
        this.sadtime = sadtime;
    }

    public String getSadaddress() {
        return sadaddress;
    }

    public void setSadaddress(String sadaddress) {
        this.sadaddress = sadaddress;
    }

}