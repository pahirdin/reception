package com.phd.reception.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * 请假条表(Leave)表实体类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@SuppressWarnings("serial")
public class Leave extends Model<Leave> {
    //请假条id
    private Integer lid;
    //申请学生id
    private Integer sid;
    //开始时间
    private Object lstime;
    //结束时间
    private Object letime;
    //请假类别(事假、病假、其它)
    private Object ltype;
    //请假理由
    private String lcontent;
    //审批人id
    private Integer aid;
    //审批状态(0待审批 1批准 2拒绝)
    private Object lstatus;


    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Object getLstime() {
        return lstime;
    }

    public void setLstime(Object lstime) {
        this.lstime = lstime;
    }

    public Object getLetime() {
        return letime;
    }

    public void setLetime(Object letime) {
        this.letime = letime;
    }

    public Object getLtype() {
        return ltype;
    }

    public void setLtype(Object ltype) {
        this.ltype = ltype;
    }

    public String getLcontent() {
        return lcontent;
    }

    public void setLcontent(String lcontent) {
        this.lcontent = lcontent;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Object getLstatus() {
        return lstatus;
    }

    public void setLstatus(Object lstatus) {
        this.lstatus = lstatus;
    }

}