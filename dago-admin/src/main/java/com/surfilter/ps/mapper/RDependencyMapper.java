package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RDependency;
import com.surfilter.ps.model.RDependencyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RDependencyMapper {
    long countByExample(RDependencyExample example);

    int deleteByExample(RDependencyExample example);

    int deleteByPrimaryKey(Long idDependency);

    int insert(RDependency record);

    int insertSelective(RDependency record);

    List<RDependency> selectByExample(RDependencyExample example);

    RDependency selectByPrimaryKey(Long idDependency);

    int updateByExampleSelective(@Param("record") RDependency record, @Param("example") RDependencyExample example);

    int updateByExample(@Param("record") RDependency record, @Param("example") RDependencyExample example);

    int updateByPrimaryKeySelective(RDependency record);

    int updateByPrimaryKey(RDependency record);
}