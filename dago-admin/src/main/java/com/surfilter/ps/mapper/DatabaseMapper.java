package com.surfilter.ps.mapper;

import com.surfilter.ps.model.Database;
import com.surfilter.ps.model.DatabaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DatabaseMapper {
    long countByExample(DatabaseExample example);

    int deleteByExample(DatabaseExample example);

    int deleteByPrimaryKey(Long idDatabase);

    int insert(Database record);

    int insertSelective(Database record);

    List<Database> selectByExampleWithBLOBs(DatabaseExample example);

    List<Database> selectByExample(DatabaseExample example);

    Database selectByPrimaryKey(Long idDatabase);

    int updateByExampleSelective(@Param("record") Database record, @Param("example") DatabaseExample example);

    int updateByExampleWithBLOBs(@Param("record") Database record, @Param("example") DatabaseExample example);

    int updateByExample(@Param("record") Database record, @Param("example") DatabaseExample example);

    int updateByPrimaryKeySelective(Database record);

    int updateByPrimaryKeyWithBLOBs(Database record);

    int updateByPrimaryKey(Database record);
}