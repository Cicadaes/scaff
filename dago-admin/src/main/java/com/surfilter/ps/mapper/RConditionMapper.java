package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RCondition;
import com.surfilter.ps.model.RConditionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RConditionMapper {
    long countByExample(RConditionExample example);

    int deleteByExample(RConditionExample example);

    int deleteByPrimaryKey(Long idCondition);

    int insert(RCondition record);

    int insertSelective(RCondition record);

    List<RCondition> selectByExample(RConditionExample example);

    RCondition selectByPrimaryKey(Long idCondition);

    int updateByExampleSelective(@Param("record") RCondition record, @Param("example") RConditionExample example);

    int updateByExample(@Param("record") RCondition record, @Param("example") RConditionExample example);

    int updateByPrimaryKeySelective(RCondition record);

    int updateByPrimaryKey(RCondition record);
}