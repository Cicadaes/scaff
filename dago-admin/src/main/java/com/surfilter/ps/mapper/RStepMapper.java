package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RStep;
import com.surfilter.ps.model.RStepExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RStepMapper {
    long countByExample(RStepExample example);

    int deleteByExample(RStepExample example);

    int deleteByPrimaryKey(Long idStep);

    int insert(RStep record);

    int insertSelective(RStep record);

    List<RStep> selectByExampleWithBLOBs(RStepExample example);

    List<RStep> selectByExample(RStepExample example);

    RStep selectByPrimaryKey(Long idStep);

    int updateByExampleSelective(@Param("record") RStep record, @Param("example") RStepExample example);

    int updateByExampleWithBLOBs(@Param("record") RStep record, @Param("example") RStepExample example);

    int updateByExample(@Param("record") RStep record, @Param("example") RStepExample example);

    int updateByPrimaryKeySelective(RStep record);

    int updateByPrimaryKeyWithBLOBs(RStep record);

    int updateByPrimaryKey(RStep record);
}