package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RStepDatabase;
import com.surfilter.ps.model.RStepDatabaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RStepDatabaseMapper {
    long countByExample(RStepDatabaseExample example);

    int deleteByExample(RStepDatabaseExample example);

    int insert(RStepDatabase record);

    int insertSelective(RStepDatabase record);

    List<RStepDatabase> selectByExample(RStepDatabaseExample example);

    int updateByExampleSelective(@Param("record") RStepDatabase record, @Param("example") RStepDatabaseExample example);

    int updateByExample(@Param("record") RStepDatabase record, @Param("example") RStepDatabaseExample example);
}