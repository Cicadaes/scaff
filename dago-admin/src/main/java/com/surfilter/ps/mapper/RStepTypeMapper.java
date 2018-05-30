package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RStepType;
import com.surfilter.ps.model.RStepTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RStepTypeMapper {
    long countByExample(RStepTypeExample example);

    int deleteByExample(RStepTypeExample example);

    int deleteByPrimaryKey(Long idStepType);

    int insert(RStepType record);

    int insertSelective(RStepType record);

    List<RStepType> selectByExample(RStepTypeExample example);

    RStepType selectByPrimaryKey(Long idStepType);

    int updateByExampleSelective(@Param("record") RStepType record, @Param("example") RStepTypeExample example);

    int updateByExample(@Param("record") RStepType record, @Param("example") RStepTypeExample example);

    int updateByPrimaryKeySelective(RStepType record);

    int updateByPrimaryKey(RStepType record);
}