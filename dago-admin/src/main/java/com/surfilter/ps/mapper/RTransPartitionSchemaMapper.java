package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RTransPartitionSchema;
import com.surfilter.ps.model.RTransPartitionSchemaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RTransPartitionSchemaMapper {
    long countByExample(RTransPartitionSchemaExample example);

    int deleteByExample(RTransPartitionSchemaExample example);

    int deleteByPrimaryKey(Long idTransPartitionSchema);

    int insert(RTransPartitionSchema record);

    int insertSelective(RTransPartitionSchema record);

    List<RTransPartitionSchema> selectByExample(RTransPartitionSchemaExample example);

    RTransPartitionSchema selectByPrimaryKey(Long idTransPartitionSchema);

    int updateByExampleSelective(@Param("record") RTransPartitionSchema record, @Param("example") RTransPartitionSchemaExample example);

    int updateByExample(@Param("record") RTransPartitionSchema record, @Param("example") RTransPartitionSchemaExample example);

    int updateByPrimaryKeySelective(RTransPartitionSchema record);

    int updateByPrimaryKey(RTransPartitionSchema record);
}