package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RTransStepCondition;
import com.surfilter.ps.model.RTransStepConditionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RTransStepConditionMapper {
    long countByExample(RTransStepConditionExample example);

    int deleteByExample(RTransStepConditionExample example);

    int insert(RTransStepCondition record);

    int insertSelective(RTransStepCondition record);

    List<RTransStepCondition> selectByExample(RTransStepConditionExample example);

    int updateByExampleSelective(@Param("record") RTransStepCondition record, @Param("example") RTransStepConditionExample example);

    int updateByExample(@Param("record") RTransStepCondition record, @Param("example") RTransStepConditionExample example);
}