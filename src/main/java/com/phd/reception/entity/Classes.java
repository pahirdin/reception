package com.phd.reception.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * 班级表(Classes)表实体类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@SuppressWarnings("serial")
public class Classes extends Model<Classes> {
    //班级id
    private Integer cid;
    //专业id
    private Integer mid;
    //班级名称
    private String cname;
    //班主任Id
    private Integer masterid;
    //辅导员ID
    private Integer insid;


    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getMasterid() {
        return masterid;
    }

    public void setMasterid(Integer masterid) {
        this.masterid = masterid;
    }

    public Integer getInsid() {
        return insid;
    }

    public void setInsid(Integer insid) {
        this.insid = insid;
    }

}