package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RDatabaseType;
import com.surfilter.ps.model.RDatabaseTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RDatabaseTypeMapper {
    long countByExample(RDatabaseTypeExample example);

    int deleteByExample(RDatabaseTypeExample example);

    int deleteByPrimaryKey(Long idDatabaseType);

    int insert(RDatabaseType record);

    int insertSelective(RDatabaseType record);

    List<RDatabaseType> selectByExample(RDatabaseTypeExample example);

    RDatabaseType selectByPrimaryKey(Long idDatabaseType);

    int updateByExampleSelective(@Param("record") RDatabaseType record, @Param("example") RDatabaseTypeExample example);

    int updateByExample(@Param("record") RDatabaseType record, @Param("example") RDatabaseTypeExample example);

    int updateByPrimaryKeySelective(RDatabaseType record);

    int updateByPrimaryKey(RDatabaseType record);
}