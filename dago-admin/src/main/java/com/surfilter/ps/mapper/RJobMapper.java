package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RJob;
import com.surfilter.ps.model.RJobExample;
import com.surfilter.ps.model.RJobWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RJobMapper {
    long countByExample(RJobExample example);

    int deleteByExample(RJobExample example);

    int deleteByPrimaryKey(Long idJob);

    int insert(RJobWithBLOBs record);

    int insertSelective(RJobWithBLOBs record);

    List<RJobWithBLOBs> selectByExampleWithBLOBs(RJobExample example);

    List<RJob> selectByExample(RJobExample example);

    RJobWithBLOBs selectByPrimaryKey(Long idJob);

    int updateByExampleSelective(@Param("record") RJobWithBLOBs record, @Param("example") RJobExample example);

    int updateByExampleWithBLOBs(@Param("record") RJobWithBLOBs record, @Param("example") RJobExample example);

    int updateByExample(@Param("record") RJob record, @Param("example") RJobExample example);

    int updateByPrimaryKeySelective(RJobWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RJobWithBLOBs record);

    int updateByPrimaryKey(RJob record);
}