package com.phd.reception.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * 请假图片表(Leavepicture)表实体类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@SuppressWarnings("serial")
public class Leavepicture extends Model<Leavepicture> {
    //图片详情表id
    private Integer lpid;
    //请假条id
    private Integer lid;
    //图片存储路径
    private String lppath;


    public Integer getLpid() {
        return lpid;
    }

    public void setLpid(Integer lpid) {
        this.lpid = lpid;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getLppath() {
        return lppath;
    }

    public void setLppath(String lppath) {
        this.lppath = lppath;
    }

}