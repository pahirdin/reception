package com.phd.reception.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.phd.reception.entity.Coursedetails;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 课程详情表(Coursedetails)表数据库访问层
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-02 11:47:30
 */
public interface CoursedetailsMapper extends BaseMapper<Coursedetails> {

    @Select("SELECT A.CDID,A.CID,A.COUID,B.CNAME FROM COURSEDETAILS A,CLASSES B  " +
            "${ew.customSqlSegment}")
    List<Coursedetails> getMajor(@Param(Constants.WRAPPER) QueryWrapper<Coursedetails> query);
}