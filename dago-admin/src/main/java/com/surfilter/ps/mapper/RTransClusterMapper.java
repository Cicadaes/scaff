package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RTransCluster;
import com.surfilter.ps.model.RTransClusterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RTransClusterMapper {
    long countByExample(RTransClusterExample example);

    int deleteByExample(RTransClusterExample example);

    int deleteByPrimaryKey(Long idTransCluster);

    int insert(RTransCluster record);

    int insertSelective(RTransCluster record);

    List<RTransCluster> selectByExample(RTransClusterExample example);

    RTransCluster selectByPrimaryKey(Long idTransCluster);

    int updateByExampleSelective(@Param("record") RTransCluster record, @Param("example") RTransClusterExample example);

    int updateByExample(@Param("record") RTransCluster record, @Param("example") RTransClusterExample example);

    int updateByPrimaryKeySelective(RTransCluster record);

    int updateByPrimaryKey(RTransCluster record);
}