package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RJobLock;
import com.surfilter.ps.model.RJobLockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RJobLockMapper {
    long countByExample(RJobLockExample example);

    int deleteByExample(RJobLockExample example);

    int deleteByPrimaryKey(Long idJobLock);

    int insert(RJobLock record);

    int insertSelective(RJobLock record);

    List<RJobLock> selectByExampleWithBLOBs(RJobLockExample example);

    List<RJobLock> selectByExample(RJobLockExample example);

    RJobLock selectByPrimaryKey(Long idJobLock);

    int updateByExampleSelective(@Param("record") RJobLock record, @Param("example") RJobLockExample example);

    int updateByExampleWithBLOBs(@Param("record") RJobLock record, @Param("example") RJobLockExample example);

    int updateByExample(@Param("record") RJobLock record, @Param("example") RJobLockExample example);

    int updateByPrimaryKeySelective(RJobLock record);

    int updateByPrimaryKeyWithBLOBs(RJobLock record);

    int updateByPrimaryKey(RJobLock record);
}