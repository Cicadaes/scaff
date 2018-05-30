package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RCluster;
import com.surfilter.ps.model.RClusterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RClusterMapper {
	long countByExample(RClusterExample example);

	int deleteByExample(RClusterExample example);

	int deleteByPrimaryKey(Long idCluster);

	int insert(RCluster record);

	int insertSelective(RCluster record);

	List<RCluster> selectByExample(RClusterExample example);

	RCluster selectByPrimaryKey(Long idCluster);

	int updateByExampleSelective(@Param("record") RCluster record, @Param("example") RClusterExample example);

	int updateByExample(@Param("record") RCluster record, @Param("example") RClusterExample example);

	int updateByPrimaryKeySelective(RCluster record);

	int updateByPrimaryKey(RCluster record);
}