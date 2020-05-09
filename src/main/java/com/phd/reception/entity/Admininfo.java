package com.phd.reception.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * (Admininfo)表实体类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:46:07
 */
@SuppressWarnings("serial")
@Data
public class Admininfo extends Model<Admininfo> {
    //管理员id
    private String aid;
    //管理员姓名
    private String aname;
    //管理员等级(1校级教务处、2院级书记、3院级辅导员、4院级班主任、5任课老师)
    private Object alevel;
    //管理员手机号
    private String atel;
    //管理员工号
    private String ano;
    //管理员密码
    private String apwd;
    //管理员所在学院(湖南工学院、计信学院、机械学院等等...通过id来获得)
    private Integer coid;

    private Integer awarnumm;
    private String aemail;

}