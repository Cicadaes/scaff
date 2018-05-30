package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RElementAttribute;
import com.surfilter.ps.model.RElementAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RElementAttributeMapper {
    long countByExample(RElementAttributeExample example);

    int deleteByExample(RElementAttributeExample example);

    int deleteByPrimaryKey(Long idElementAttribute);

    int insert(RElementAttribute record);

    int insertSelective(RElementAttribute record);

    List<RElementAttribute> selectByExampleWithBLOBs(RElementAttributeExample example);

    List<RElementAttribute> selectByExample(RElementAttributeExample example);

    RElementAttribute selectByPrimaryKey(Long idElementAttribute);

    int updateByExampleSelective(@Param("record") RElementAttribute record, @Param("example") RElementAttributeExample example);

    int updateByExampleWithBLOBs(@Param("record") RElementAttribute record, @Param("example") RElementAttributeExample example);

    int updateByExample(@Param("record") RElementAttribute record, @Param("example") RElementAttributeExample example);

    int updateByPrimaryKeySelective(RElementAttribute record);

    int updateByPrimaryKeyWithBLOBs(RElementAttribute record);

    int updateByPrimaryKey(RElementAttribute record);
}