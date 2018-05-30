package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RDirectory;
import com.surfilter.ps.model.RDirectoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RDirectoryMapper {
    long countByExample(RDirectoryExample example);

    int deleteByExample(RDirectoryExample example);

    int deleteByPrimaryKey(Long idDirectory);

    int insert(RDirectory record);

    int insertSelective(RDirectory record);

    List<RDirectory> selectByExample(RDirectoryExample example);

    RDirectory selectByPrimaryKey(Long idDirectory);

    int updateByExampleSelective(@Param("record") RDirectory record, @Param("example") RDirectoryExample example);

    int updateByExample(@Param("record") RDirectory record, @Param("example") RDirectoryExample example);

    int updateByPrimaryKeySelective(RDirectory record);

    int updateByPrimaryKey(RDirectory record);
}