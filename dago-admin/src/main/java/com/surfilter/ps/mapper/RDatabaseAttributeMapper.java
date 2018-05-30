package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RDatabaseAttribute;
import com.surfilter.ps.model.RDatabaseAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RDatabaseAttributeMapper {
    long countByExample(RDatabaseAttributeExample example);

    int deleteByExample(RDatabaseAttributeExample example);

    int deleteByPrimaryKey(Long idDatabaseAttribute);

    int insert(RDatabaseAttribute record);

    int insertSelective(RDatabaseAttribute record);

    List<RDatabaseAttribute> selectByExampleWithBLOBs(RDatabaseAttributeExample example);

    List<RDatabaseAttribute> selectByExample(RDatabaseAttributeExample example);

    RDatabaseAttribute selectByPrimaryKey(Long idDatabaseAttribute);

    int updateByExampleSelective(@Param("record") RDatabaseAttribute record, @Param("example") RDatabaseAttributeExample example);

    int updateByExampleWithBLOBs(@Param("record") RDatabaseAttribute record, @Param("example") RDatabaseAttributeExample example);

    int updateByExample(@Param("record") RDatabaseAttribute record, @Param("example") RDatabaseAttributeExample example);

    int updateByPrimaryKeySelective(RDatabaseAttribute record);

    int updateByPrimaryKeyWithBLOBs(RDatabaseAttribute record);

    int updateByPrimaryKey(RDatabaseAttribute record);
}