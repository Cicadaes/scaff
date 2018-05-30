package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RJobentryType;
import com.surfilter.ps.model.RJobentryTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RJobentryTypeMapper {
    long countByExample(RJobentryTypeExample example);

    int deleteByExample(RJobentryTypeExample example);

    int deleteByPrimaryKey(Long idJobentryType);

    int insert(RJobentryType record);

    int insertSelective(RJobentryType record);

    List<RJobentryType> selectByExample(RJobentryTypeExample example);

    RJobentryType selectByPrimaryKey(Long idJobentryType);

    int updateByExampleSelective(@Param("record") RJobentryType record, @Param("example") RJobentryTypeExample example);

    int updateByExample(@Param("record") RJobentryType record, @Param("example") RJobentryTypeExample example);

    int updateByPrimaryKeySelective(RJobentryType record);

    int updateByPrimaryKey(RJobentryType record);
}