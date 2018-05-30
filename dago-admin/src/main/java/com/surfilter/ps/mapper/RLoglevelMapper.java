package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RLoglevel;
import com.surfilter.ps.model.RLoglevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RLoglevelMapper {
    long countByExample(RLoglevelExample example);

    int deleteByExample(RLoglevelExample example);

    int deleteByPrimaryKey(Long idLoglevel);

    int insert(RLoglevel record);

    int insertSelective(RLoglevel record);

    List<RLoglevel> selectByExample(RLoglevelExample example);

    RLoglevel selectByPrimaryKey(Long idLoglevel);

    int updateByExampleSelective(@Param("record") RLoglevel record, @Param("example") RLoglevelExample example);

    int updateByExample(@Param("record") RLoglevel record, @Param("example") RLoglevelExample example);

    int updateByPrimaryKeySelective(RLoglevel record);

    int updateByPrimaryKey(RLoglevel record);
}