package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RTransAttribute;
import com.surfilter.ps.model.RTransAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RTransAttributeMapper {
    long countByExample(RTransAttributeExample example);

    int deleteByExample(RTransAttributeExample example);

    int deleteByPrimaryKey(Long idTransAttribute);

    int insert(RTransAttribute record);

    int insertSelective(RTransAttribute record);

    List<RTransAttribute> selectByExampleWithBLOBs(RTransAttributeExample example);

    List<RTransAttribute> selectByExample(RTransAttributeExample example);

    RTransAttribute selectByPrimaryKey(Long idTransAttribute);

    int updateByExampleSelective(@Param("record") RTransAttribute record, @Param("example") RTransAttributeExample example);

    int updateByExampleWithBLOBs(@Param("record") RTransAttribute record, @Param("example") RTransAttributeExample example);

    int updateByExample(@Param("record") RTransAttribute record, @Param("example") RTransAttributeExample example);

    int updateByPrimaryKeySelective(RTransAttribute record);

    int updateByPrimaryKeyWithBLOBs(RTransAttribute record);

    int updateByPrimaryKey(RTransAttribute record);
}