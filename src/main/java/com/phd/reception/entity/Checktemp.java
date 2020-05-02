package com.phd.reception.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Checktemp)表实体类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@SuppressWarnings("serial")
public class Checktemp extends Model<Checktemp> {
    
    private Integer tid;
    
    private String tno;
    
    private String tname;
    
    private String tpwd;
    
    private String ttel;
    
    private String coname;
    
    private Integer spare1;
    
    private Integer spare2;
    
    private String spare3;
    
    private String spare4;
    
    private String spare5;
    
    private String recordid;
    
    private Integer checcode;
    
    private String checkinfo;
    
    private Object tmpid;
    
    private String spare6;
    
    private Integer spare7;


    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTpwd() {
        return tpwd;
    }

    public void setTpwd(String tpwd) {
        this.tpwd = tpwd;
    }

    public String getTtel() {
        return ttel;
    }

    public void setTtel(String ttel) {
        this.ttel = ttel;
    }

    public String getConame() {
        return coname;
    }

    public void setConame(String coname) {
        this.coname = coname;
    }

    public Integer getSpare1() {
        return spare1;
    }

    public void setSpare1(Integer spare1) {
        this.spare1 = spare1;
    }

    public Integer getSpare2() {
        return spare2;
    }

    public void setSpare2(Integer spare2) {
        this.spare2 = spare2;
    }

    public String getSpare3() {
        return spare3;
    }

    public void setSpare3(String spare3) {
        this.spare3 = spare3;
    }

    public String getSpare4() {
        return spare4;
    }

    public void setSpare4(String spare4) {
        this.spare4 = spare4;
    }

    public String getSpare5() {
        return spare5;
    }

    public void setSpare5(String spare5) {
        this.spare5 = spare5;
    }

    public String getRecordid() {
        return recordid;
    }

    public void setRecordid(String recordid) {
        this.recordid = recordid;
    }

    public Integer getCheccode() {
        return checcode;
    }

    public void setCheccode(Integer checcode) {
        this.checcode = checcode;
    }

    public String getCheckinfo() {
        return checkinfo;
    }

    public void setCheckinfo(String checkinfo) {
        this.checkinfo = checkinfo;
    }

    public Object getTmpid() {
        return tmpid;
    }

    public void setTmpid(Object tmpid) {
        this.tmpid = tmpid;
    }

    public String getSpare6() {
        return spare6;
    }

    public void setSpare6(String spare6) {
        this.spare6 = spare6;
    }

    public Integer getSpare7() {
        return spare7;
    }

    public void setSpare7(Integer spare7) {
        this.spare7 = spare7;
    }

}