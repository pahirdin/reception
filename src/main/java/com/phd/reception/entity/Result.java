package com.phd.reception.entity;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;

/**
 * @author pahaied
 * @date 2019/12/13 16:12
 */
@Data
public class Result<T> {
    private List<T> data;
    private long code;
    private long count;
    private String msg;

    public Result(Page<T> page){
        this.data = page.getRecords();
        this.code = 0;
        this.msg = "";
        this.count = page.getTotal();
    }
    public Result(){
        this.data = null;
        this.code = 0;
        this.msg = "";
        this.count = 0;
    }

}
