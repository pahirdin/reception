package com.phd.reception.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 上课考勤详情表(Schoolattendancedetails)表实体类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@SuppressWarnings("serial")
@Data
public class Schoolattendancedetails extends Model<Schoolattendancedetails> {
    //考勤详情id
    private Integer sadid;
    //考勤id
    private Long said;
    //课程id
    private Integer couid;
    //学生id
    private Integer sid;
    //学生是否签到(0未签到,缺勤 1已签到 2请假)
    private Integer sadstatus;
    //学生签到时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sadtime;
    //签到地点
    private String sadaddress;

}