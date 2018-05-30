package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RJobentryDatabase;
import com.surfilter.ps.model.RJobentryDatabaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RJobentryDatabaseMapper {
    long countByExample(RJobentryDatabaseExample example);

    int deleteByExample(RJobentryDatabaseExample example);

    int insert(RJobentryDatabase record);

    int insertSelective(RJobentryDatabase record);

    List<RJobentryDatabase> selectByExample(RJobentryDatabaseExample example);

    int updateByExampleSelective(@Param("record") RJobentryDatabase record, @Param("example") RJobentryDatabaseExample example);

    int updateByExample(@Param("record") RJobentryDatabase record, @Param("example") RJobentryDatabaseExample example);
}