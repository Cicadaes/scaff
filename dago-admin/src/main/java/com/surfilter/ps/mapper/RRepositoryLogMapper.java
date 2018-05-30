package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RRepositoryLog;
import com.surfilter.ps.model.RRepositoryLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RRepositoryLogMapper {
    long countByExample(RRepositoryLogExample example);

    int deleteByExample(RRepositoryLogExample example);

    int deleteByPrimaryKey(Long idRepositoryLog);

    int insert(RRepositoryLog record);

    int insertSelective(RRepositoryLog record);

    List<RRepositoryLog> selectByExampleWithBLOBs(RRepositoryLogExample example);

    List<RRepositoryLog> selectByExample(RRepositoryLogExample example);

    RRepositoryLog selectByPrimaryKey(Long idRepositoryLog);

    int updateByExampleSelective(@Param("record") RRepositoryLog record, @Param("example") RRepositoryLogExample example);

    int updateByExampleWithBLOBs(@Param("record") RRepositoryLog record, @Param("example") RRepositoryLogExample example);

    int updateByExample(@Param("record") RRepositoryLog record, @Param("example") RRepositoryLogExample example);

    int updateByPrimaryKeySelective(RRepositoryLog record);

    int updateByPrimaryKeyWithBLOBs(RRepositoryLog record);

    int updateByPrimaryKey(RRepositoryLog record);
}