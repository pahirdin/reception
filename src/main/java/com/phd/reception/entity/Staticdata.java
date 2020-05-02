package com.phd.reception.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Staticdata)表实体类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@SuppressWarnings("serial")
public class Staticdata extends Model<Staticdata> {
    
    private Integer dataid;
    
    private Integer datacode;
    
    private String dataname;
    
    private Integer datadese;


    public Integer getDataid() {
        return dataid;
    }

    public void setDataid(Integer dataid) {
        this.dataid = dataid;
    }

    public Integer getDatacode() {
        return datacode;
    }

    public void setDatacode(Integer datacode) {
        this.datacode = datacode;
    }

    public String getDataname() {
        return dataname;
    }

    public void setDataname(String dataname) {
        this.dataname = dataname;
    }

    public Integer getDatadese() {
        return datadese;
    }

    public void setDatadese(Integer datadese) {
        this.datadese = datadese;
    }

}