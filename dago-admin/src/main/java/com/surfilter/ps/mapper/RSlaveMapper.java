package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RSlave;
import com.surfilter.ps.model.RSlaveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RSlaveMapper {
    long countByExample(RSlaveExample example);

    int deleteByExample(RSlaveExample example);

    int deleteByPrimaryKey(Long idSlave);

    int insert(RSlave record);

    int insertSelective(RSlave record);

    List<RSlave> selectByExample(RSlaveExample example);

    RSlave selectByPrimaryKey(Long idSlave);

    int updateByExampleSelective(@Param("record") RSlave record, @Param("example") RSlaveExample example);

    int updateByExample(@Param("record") RSlave record, @Param("example") RSlaveExample example);

    int updateByPrimaryKeySelective(RSlave record);

    int updateByPrimaryKey(RSlave record);
}