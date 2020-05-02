package com.phd.reception.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.phd.reception.entity.Classes;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 班级表(Classes)表数据库访问层
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
public interface ClassesMapper extends BaseMapper<Classes> {

    @Select("SELECT CNAME FROM CLASSES WHERE CID=#{cid}")
    String getClassesNameById(@Param("cid") Integer cid);
}