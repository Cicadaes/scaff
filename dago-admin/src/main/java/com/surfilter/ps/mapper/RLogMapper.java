package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RLog;
import com.surfilter.ps.model.RLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RLogMapper {
    long countByExample(RLogExample example);

    int deleteByExample(RLogExample example);

    int deleteByPrimaryKey(Long idLog);

    int insert(RLog record);

    int insertSelective(RLog record);

    List<RLog> selectByExample(RLogExample example);

    RLog selectByPrimaryKey(Long idLog);

    int updateByExampleSelective(@Param("record") RLog record, @Param("example") RLogExample example);

    int updateByExample(@Param("record") RLog record, @Param("example") RLogExample example);

    int updateByPrimaryKeySelective(RLog record);

    int updateByPrimaryKey(RLog record);
}