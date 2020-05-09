package com.phd.reception.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * 班级表(Classes)表实体类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@SuppressWarnings("serial")
@Data
public class Classes extends Model<Classes> {
    //班级id
    private Integer cid;
    //专业id
    private Integer mid;
    //班级名称
    private String cname;
    //班主任Id
    private String masterid;
    //辅导员ID
    private String insid;

}