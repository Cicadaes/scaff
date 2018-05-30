package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RClusterSlave;
import com.surfilter.ps.model.RClusterSlaveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RClusterSlaveMapper {
    long countByExample(RClusterSlaveExample example);

    int deleteByExample(RClusterSlaveExample example);

    int deleteByPrimaryKey(Long idClusterSlave);

    int insert(RClusterSlave record);

    int insertSelective(RClusterSlave record);

    List<RClusterSlave> selectByExample(RClusterSlaveExample example);

    RClusterSlave selectByPrimaryKey(Long idClusterSlave);

    int updateByExampleSelective(@Param("record") RClusterSlave record, @Param("example") RClusterSlaveExample example);

    int updateByExample(@Param("record") RClusterSlave record, @Param("example") RClusterSlaveExample example);

    int updateByPrimaryKeySelective(RClusterSlave record);

    int updateByPrimaryKey(RClusterSlave record);
}