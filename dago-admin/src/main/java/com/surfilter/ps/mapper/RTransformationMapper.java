package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RTransformation;
import com.surfilter.ps.model.RTransformationExample;
import com.surfilter.ps.model.RTransformationWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RTransformationMapper {
    long countByExample(RTransformationExample example);

    int deleteByExample(RTransformationExample example);

    int deleteByPrimaryKey(Long idTransformation);

    int insert(RTransformationWithBLOBs record);

    int insertSelective(RTransformationWithBLOBs record);

    List<RTransformationWithBLOBs> selectByExampleWithBLOBs(RTransformationExample example);

    List<RTransformation> selectByExample(RTransformationExample example);

    RTransformationWithBLOBs selectByPrimaryKey(Long idTransformation);

    int updateByExampleSelective(@Param("record") RTransformationWithBLOBs record, @Param("example") RTransformationExample example);

    int updateByExampleWithBLOBs(@Param("record") RTransformationWithBLOBs record, @Param("example") RTransformationExample example);

    int updateByExample(@Param("record") RTransformation record, @Param("example") RTransformationExample example);

    int updateByPrimaryKeySelective(RTransformationWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RTransformationWithBLOBs record);

    int updateByPrimaryKey(RTransformation record);
}