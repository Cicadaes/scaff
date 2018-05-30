package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RNamespace;
import com.surfilter.ps.model.RNamespaceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RNamespaceMapper {
    long countByExample(RNamespaceExample example);

    int deleteByExample(RNamespaceExample example);

    int deleteByPrimaryKey(Long idNamespace);

    int insert(RNamespace record);

    int insertSelective(RNamespace record);

    List<RNamespace> selectByExampleWithBLOBs(RNamespaceExample example);

    List<RNamespace> selectByExample(RNamespaceExample example);

    RNamespace selectByPrimaryKey(Long idNamespace);

    int updateByExampleSelective(@Param("record") RNamespace record, @Param("example") RNamespaceExample example);

    int updateByExampleWithBLOBs(@Param("record") RNamespace record, @Param("example") RNamespaceExample example);

    int updateByExample(@Param("record") RNamespace record, @Param("example") RNamespaceExample example);

    int updateByPrimaryKeySelective(RNamespace record);

    int updateByPrimaryKeyWithBLOBs(RNamespace record);
}