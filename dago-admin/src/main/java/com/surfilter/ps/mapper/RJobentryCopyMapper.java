package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RJobentryCopy;
import com.surfilter.ps.model.RJobentryCopyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RJobentryCopyMapper {
    long countByExample(RJobentryCopyExample example);

    int deleteByExample(RJobentryCopyExample example);

    int deleteByPrimaryKey(Long idJobentryCopy);

    int insert(RJobentryCopy record);

    int insertSelective(RJobentryCopy record);

    List<RJobentryCopy> selectByExample(RJobentryCopyExample example);

    RJobentryCopy selectByPrimaryKey(Long idJobentryCopy);

    int updateByExampleSelective(@Param("record") RJobentryCopy record, @Param("example") RJobentryCopyExample example);

    int updateByExample(@Param("record") RJobentryCopy record, @Param("example") RJobentryCopyExample example);

    int updateByPrimaryKeySelective(RJobentryCopy record);

    int updateByPrimaryKey(RJobentryCopy record);
}