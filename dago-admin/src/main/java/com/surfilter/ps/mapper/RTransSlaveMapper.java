package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RTransSlave;
import com.surfilter.ps.model.RTransSlaveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RTransSlaveMapper {
    long countByExample(RTransSlaveExample example);

    int deleteByExample(RTransSlaveExample example);

    int deleteByPrimaryKey(Long idTransSlave);

    int insert(RTransSlave record);

    int insertSelective(RTransSlave record);

    List<RTransSlave> selectByExample(RTransSlaveExample example);

    RTransSlave selectByPrimaryKey(Long idTransSlave);

    int updateByExampleSelective(@Param("record") RTransSlave record, @Param("example") RTransSlaveExample example);

    int updateByExample(@Param("record") RTransSlave record, @Param("example") RTransSlaveExample example);

    int updateByPrimaryKeySelective(RTransSlave record);

    int updateByPrimaryKey(RTransSlave record);
}