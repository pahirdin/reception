package com.phd.reception.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.phd.reception.entity.Course;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 课程表(Course)表数据库访问层
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
public interface CourseMapper extends BaseMapper<Course> {

    @Select("SELECT COUNAME FROM COURSE WHERE COUID=#{couid}")
    String getCounameByCouid(@Param("couid") Integer couid);

    @Select("SELECT COUID FROM COURSE WHERE AID=#{aid}")
    List<Integer> getCouidList(@Param("aid") Integer aid);
}