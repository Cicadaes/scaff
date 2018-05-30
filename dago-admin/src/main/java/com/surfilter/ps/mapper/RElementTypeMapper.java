package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RElementType;
import com.surfilter.ps.model.RElementTypeExample;
import com.surfilter.ps.model.RElementTypeWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RElementTypeMapper {
    long countByExample(RElementTypeExample example);

    int deleteByExample(RElementTypeExample example);

    int deleteByPrimaryKey(Long idElementType);

    int insert(RElementTypeWithBLOBs record);

    int insertSelective(RElementTypeWithBLOBs record);

    List<RElementTypeWithBLOBs> selectByExampleWithBLOBs(RElementTypeExample example);

    List<RElementType> selectByExample(RElementTypeExample example);

    RElementTypeWithBLOBs selectByPrimaryKey(Long idElementType);

    int updateByExampleSelective(@Param("record") RElementTypeWithBLOBs record, @Param("example") RElementTypeExample example);

    int updateByExampleWithBLOBs(@Param("record") RElementTypeWithBLOBs record, @Param("example") RElementTypeExample example);

    int updateByExample(@Param("record") RElementType record, @Param("example") RElementTypeExample example);

    int updateByPrimaryKeySelective(RElementTypeWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RElementTypeWithBLOBs record);

    int updateByPrimaryKey(RElementType record);
}