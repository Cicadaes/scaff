package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RTransHop;
import com.surfilter.ps.model.RTransHopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RTransHopMapper {
    long countByExample(RTransHopExample example);

    int deleteByExample(RTransHopExample example);

    int deleteByPrimaryKey(Long idTransHop);

    int insert(RTransHop record);

    int insertSelective(RTransHop record);

    List<RTransHop> selectByExample(RTransHopExample example);

    RTransHop selectByPrimaryKey(Long idTransHop);

    int updateByExampleSelective(@Param("record") RTransHop record, @Param("example") RTransHopExample example);

    int updateByExample(@Param("record") RTransHop record, @Param("example") RTransHopExample example);

    int updateByPrimaryKeySelective(RTransHop record);

    int updateByPrimaryKey(RTransHop record);
}