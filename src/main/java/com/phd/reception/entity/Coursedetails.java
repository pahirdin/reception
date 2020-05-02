package com.phd.reception.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 课程详情表(Coursedetails)表实体类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-02 11:47:30
 */
@SuppressWarnings("serial")
@Data
public class Coursedetails extends Model<Coursedetails> {
    //唯一标识
    private Integer cdid;
    //课程id
    private Integer couid;
    //班级id
    private Integer cid;

    private String cname;
}