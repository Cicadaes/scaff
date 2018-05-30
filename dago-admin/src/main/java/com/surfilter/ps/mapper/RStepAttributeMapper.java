package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RStepAttribute;
import com.surfilter.ps.model.RStepAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RStepAttributeMapper {
    long countByExample(RStepAttributeExample example);

    int deleteByExample(RStepAttributeExample example);

    int deleteByPrimaryKey(Long idStepAttribute);

    int insert(RStepAttribute record);

    int insertSelective(RStepAttribute record);

    List<RStepAttribute> selectByExampleWithBLOBs(RStepAttributeExample example);

    List<RStepAttribute> selectByExample(RStepAttributeExample example);

    RStepAttribute selectByPrimaryKey(Long idStepAttribute);

    int updateByExampleSelective(@Param("record") RStepAttribute record, @Param("example") RStepAttributeExample example);

    int updateByExampleWithBLOBs(@Param("record") RStepAttribute record, @Param("example") RStepAttributeExample example);

    int updateByExample(@Param("record") RStepAttribute record, @Param("example") RStepAttributeExample example);

    int updateByPrimaryKeySelective(RStepAttribute record);

    int updateByPrimaryKeyWithBLOBs(RStepAttribute record);

    int updateByPrimaryKey(RStepAttribute record);
}