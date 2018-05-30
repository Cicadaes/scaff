package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RVersion;
import com.surfilter.ps.model.RVersionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RVersionMapper {
    long countByExample(RVersionExample example);

    int deleteByExample(RVersionExample example);

    int deleteByPrimaryKey(Long idVersion);

    int insert(RVersion record);

    int insertSelective(RVersion record);

    List<RVersion> selectByExample(RVersionExample example);

    RVersion selectByPrimaryKey(Long idVersion);

    int updateByExampleSelective(@Param("record") RVersion record, @Param("example") RVersionExample example);

    int updateByExample(@Param("record") RVersion record, @Param("example") RVersionExample example);

    int updateByPrimaryKeySelective(RVersion record);

    int updateByPrimaryKey(RVersion record);
}