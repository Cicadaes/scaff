package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RDatabase;
import com.surfilter.ps.model.RDatabaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RDatabaseMapper {
    long countByExample(RDatabaseExample example);

    int deleteByExample(RDatabaseExample example);

    int deleteByPrimaryKey(Long idDatabase);

    int insert(RDatabase record);

    int insertSelective(RDatabase record);

    List<RDatabase> selectByExampleWithBLOBs(RDatabaseExample example);

    List<RDatabase> selectByExample(RDatabaseExample example);

    RDatabase selectByPrimaryKey(Long idDatabase);

    int updateByExampleSelective(@Param("record") RDatabase record, @Param("example") RDatabaseExample example);

    int updateByExampleWithBLOBs(@Param("record") RDatabase record, @Param("example") RDatabaseExample example);

    int updateByExample(@Param("record") RDatabase record, @Param("example") RDatabaseExample example);

    int updateByPrimaryKeySelective(RDatabase record);

    int updateByPrimaryKeyWithBLOBs(RDatabase record);

    int updateByPrimaryKey(RDatabase record);
}