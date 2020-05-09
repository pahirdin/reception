package com.phd.reception.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 上课考勤表(Schoolattendance)表实体类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@SuppressWarnings("serial")
@Data
public class Schoolattendance extends Model<Schoolattendance> {
    //考勤id
    private Long said;
    //考勤班级id
    private Integer cid;
    @TableField(exist = false)
    private String cname;
    //班级总人数
    private Integer sanum;
    //班级到勤人数
    private Integer sainum;
    //班级到勤率
    private Integer sarate;
    //课程id
    private Integer couid;
    @TableField(exist = false)
    private String couname;
    //考勤码(防止学生多次提交)
    private Object sacode;
    //提交时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime satime;
    //提交地点
    private String saaddress;

}