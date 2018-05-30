package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RJobHop;
import com.surfilter.ps.model.RJobHopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RJobHopMapper {
    long countByExample(RJobHopExample example);

    int deleteByExample(RJobHopExample example);

    int deleteByPrimaryKey(Long idJobHop);

    int insert(RJobHop record);

    int insertSelective(RJobHop record);

    List<RJobHop> selectByExample(RJobHopExample example);

    RJobHop selectByPrimaryKey(Long idJobHop);

    int updateByExampleSelective(@Param("record") RJobHop record, @Param("example") RJobHopExample example);

    int updateByExample(@Param("record") RJobHop record, @Param("example") RJobHopExample example);

    int updateByPrimaryKeySelective(RJobHop record);

    int updateByPrimaryKey(RJobHop record);
}