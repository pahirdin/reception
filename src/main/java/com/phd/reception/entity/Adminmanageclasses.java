package com.phd.reception.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * 辅导员管理班级表(Adminmanageclasses)表实体类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@SuppressWarnings("serial")
public class Adminmanageclasses extends Model<Adminmanageclasses> {
    //该表id
    private Integer amcid;
    //辅导员id
    private Integer aid;


    public Integer getAmcid() {
        return amcid;
    }

    public void setAmcid(Integer amcid) {
        this.amcid = amcid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

}