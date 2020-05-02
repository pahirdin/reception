package com.phd.reception.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Admininfo)表实体类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:46:07
 */
@SuppressWarnings("serial")
public class Admininfo extends Model<Admininfo> {
    //管理员id
    private Integer aid;
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


    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Object getAlevel() {
        return alevel;
    }

    public void setAlevel(Object alevel) {
        this.alevel = alevel;
    }

    public String getAtel() {
        return atel;
    }

    public void setAtel(String atel) {
        this.atel = atel;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getApwd() {
        return apwd;
    }

    public void setApwd(String apwd) {
        this.apwd = apwd;
    }

    public Integer getCoid() {
        return coid;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
    }

}