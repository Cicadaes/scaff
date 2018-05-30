package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RPartition;
import com.surfilter.ps.model.RPartitionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RPartitionMapper {
    long countByExample(RPartitionExample example);

    int deleteByExample(RPartitionExample example);

    int deleteByPrimaryKey(Long idPartition);

    int insert(RPartition record);

    int insertSelective(RPartition record);

    List<RPartition> selectByExample(RPartitionExample example);

    RPartition selectByPrimaryKey(Long idPartition);

    int updateByExampleSelective(@Param("record") RPartition record, @Param("example") RPartitionExample example);

    int updateByExample(@Param("record") RPartition record, @Param("example") RPartitionExample example);

    int updateByPrimaryKeySelective(RPartition record);

    int updateByPrimaryKey(RPartition record);
}