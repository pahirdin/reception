package com.phd.reception.entity;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author pahaied
 * @date 2019/12/13 16:12
 */
@Data
public class ResultMap<T> {
    private List<Map<String,Object>> data;
    private long code;
    private long count;
    private String msg;

    public ResultMap(){
        this.data = null;
        this.code = 0;
        this.msg = "";
        this.count = 0;
    }

public ResultMap(Page<Map<String, Object>> mapPage){
        this.data = mapPage.getRecords();
        this.code = 0;
        this.msg = "";
        this.count = mapPage.getCurrent();
    }


}
