package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RTransLock;
import com.surfilter.ps.model.RTransLockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RTransLockMapper {
    long countByExample(RTransLockExample example);

    int deleteByExample(RTransLockExample example);

    int deleteByPrimaryKey(Long idTransLock);

    int insert(RTransLock record);

    int insertSelective(RTransLock record);

    List<RTransLock> selectByExampleWithBLOBs(RTransLockExample example);

    List<RTransLock> selectByExample(RTransLockExample example);

    RTransLock selectByPrimaryKey(Long idTransLock);

    int updateByExampleSelective(@Param("record") RTransLock record, @Param("example") RTransLockExample example);

    int updateByExampleWithBLOBs(@Param("record") RTransLock record, @Param("example") RTransLockExample example);

    int updateByExample(@Param("record") RTransLock record, @Param("example") RTransLockExample example);

    int updateByPrimaryKeySelective(RTransLock record);

    int updateByPrimaryKeyWithBLOBs(RTransLock record);

    int updateByPrimaryKey(RTransLock record);
}