package com.phd.reception.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * 请假条表(Leave)表实体类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@SuppressWarnings("serial")
@Data
public class Leave extends Model<Leave> {
    //请假条id
    private Integer lid;
    //申请学生id
    private Integer sid;
    //开始时间
    private Object lstime;
    //结束时间
    private Object letime;
    //请假类别(事假、病假、其它)
    private Integer ltype;
    //请假理由
    private String lcontent;
    //审批人id
    private String aid;
    //审批状态(0待审批 1批准 2拒绝)
    private Integer lstatus;

}