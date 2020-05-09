package com.phd.reception.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * 课程表(Course)表实体类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@SuppressWarnings("serial")
@Data
public class Course extends Model<Course> {
    //课程id
    private Integer couid;
    //课程名称
    private String couname;
    //班级id
    private String aid;
}