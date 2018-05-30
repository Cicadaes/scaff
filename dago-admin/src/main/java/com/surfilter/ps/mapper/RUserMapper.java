package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RUser;
import com.surfilter.ps.model.RUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RUserMapper {
    long countByExample(RUserExample example);

    int deleteByExample(RUserExample example);

    int deleteByPrimaryKey(Long idUser);

    int insert(RUser record);

    int insertSelective(RUser record);

    List<RUser> selectByExample(RUserExample example);

    RUser selectByPrimaryKey(Long idUser);

    int updateByExampleSelective(@Param("record") RUser record, @Param("example") RUserExample example);

    int updateByExample(@Param("record") RUser record, @Param("example") RUserExample example);

    int updateByPrimaryKeySelective(RUser record);

    int updateByPrimaryKey(RUser record);
}