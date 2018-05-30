package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RDatabaseContype;
import com.surfilter.ps.model.RDatabaseContypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RDatabaseContypeMapper {
    long countByExample(RDatabaseContypeExample example);

    int deleteByExample(RDatabaseContypeExample example);

    int deleteByPrimaryKey(Long idDatabaseContype);

    int insert(RDatabaseContype record);

    int insertSelective(RDatabaseContype record);

    List<RDatabaseContype> selectByExample(RDatabaseContypeExample example);

    RDatabaseContype selectByPrimaryKey(Long idDatabaseContype);

    int updateByExampleSelective(@Param("record") RDatabaseContype record, @Param("example") RDatabaseContypeExample example);

    int updateByExample(@Param("record") RDatabaseContype record, @Param("example") RDatabaseContypeExample example);

    int updateByPrimaryKeySelective(RDatabaseContype record);

    int updateByPrimaryKey(RDatabaseContype record);
}