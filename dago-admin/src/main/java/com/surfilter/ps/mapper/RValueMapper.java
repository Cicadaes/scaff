package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RValue;
import com.surfilter.ps.model.RValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RValueMapper {
    long countByExample(RValueExample example);

    int deleteByExample(RValueExample example);

    int deleteByPrimaryKey(Long idValue);

    int insert(RValue record);

    int insertSelective(RValue record);

    List<RValue> selectByExample(RValueExample example);

    RValue selectByPrimaryKey(Long idValue);

    int updateByExampleSelective(@Param("record") RValue record, @Param("example") RValueExample example);

    int updateByExample(@Param("record") RValue record, @Param("example") RValueExample example);

    int updateByPrimaryKeySelective(RValue record);

    int updateByPrimaryKey(RValue record);
}