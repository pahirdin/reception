package com.phd.reception.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.phd.reception.entity.Studentinfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Studentinfo)表数据库访问层
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
public interface StudentinfoMapper extends BaseMapper<Studentinfo> {

    @Select("select sid,sno,sname,cid,stel,sdor,sptel from studentinfo where sid in ( \n" +
            " SELECT a.sid FROM studentinfo a,schoolattendancedetails b where a.sid=b.sid and b.couid=#{couid}  and b.sadstatus = '0' GROUP BY a.sid HAVING count(a.sid)>#{awarnumm}  \n" +
            " )")
    List<Studentinfo> queryListByCouidAndWarnumm(@Param("couid") Integer couid,@Param("awarnumm") Integer awarnumm);
}