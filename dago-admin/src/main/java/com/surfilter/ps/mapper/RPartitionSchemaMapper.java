package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RPartitionSchema;
import com.surfilter.ps.model.RPartitionSchemaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RPartitionSchemaMapper {
    long countByExample(RPartitionSchemaExample example);

    int deleteByExample(RPartitionSchemaExample example);

    int deleteByPrimaryKey(Long idPartitionSchema);

    int insert(RPartitionSchema record);

    int insertSelective(RPartitionSchema record);

    List<RPartitionSchema> selectByExample(RPartitionSchemaExample example);

    RPartitionSchema selectByPrimaryKey(Long idPartitionSchema);

    int updateByExampleSelective(@Param("record") RPartitionSchema record, @Param("example") RPartitionSchemaExample example);

    int updateByExample(@Param("record") RPartitionSchema record, @Param("example") RPartitionSchemaExample example);

    int updateByPrimaryKeySelective(RPartitionSchema record);

    int updateByPrimaryKey(RPartitionSchema record);
}