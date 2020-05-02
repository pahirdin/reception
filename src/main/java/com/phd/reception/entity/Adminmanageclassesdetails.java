package com.phd.reception.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * 辅导员管理班级详情表(Adminmanageclassesdetails)表实体类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@SuppressWarnings("serial")
public class Adminmanageclassesdetails extends Model<Adminmanageclassesdetails> {
    //详情表id
    private Integer amcdid;
    //辅导员管理班级表id
    private Integer amcid;
    //班级id
    private Integer cid;


    public Integer getAmcdid() {
        return amcdid;
    }

    public void setAmcdid(Integer amcdid) {
        this.amcdid = amcdid;
    }

    public Integer getAmcid() {
        return amcid;
    }

    public void setAmcid(Integer amcid) {
        this.amcid = amcid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

}