package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RJobentry;
import com.surfilter.ps.model.RJobentryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RJobentryMapper {
    long countByExample(RJobentryExample example);

    int deleteByExample(RJobentryExample example);

    int deleteByPrimaryKey(Long idJobentry);

    int insert(RJobentry record);

    int insertSelective(RJobentry record);

    List<RJobentry> selectByExampleWithBLOBs(RJobentryExample example);

    List<RJobentry> selectByExample(RJobentryExample example);

    RJobentry selectByPrimaryKey(Long idJobentry);

    int updateByExampleSelective(@Param("record") RJobentry record, @Param("example") RJobentryExample example);

    int updateByExampleWithBLOBs(@Param("record") RJobentry record, @Param("example") RJobentryExample example);

    int updateByExample(@Param("record") RJobentry record, @Param("example") RJobentryExample example);

    int updateByPrimaryKeySelective(RJobentry record);

    int updateByPrimaryKeyWithBLOBs(RJobentry record);

    int updateByPrimaryKey(RJobentry record);
}