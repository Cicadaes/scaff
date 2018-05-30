package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RJobNote;
import com.surfilter.ps.model.RJobNoteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RJobNoteMapper {
    long countByExample(RJobNoteExample example);

    int deleteByExample(RJobNoteExample example);

    int insert(RJobNote record);

    int insertSelective(RJobNote record);

    List<RJobNote> selectByExample(RJobNoteExample example);

    int updateByExampleSelective(@Param("record") RJobNote record, @Param("example") RJobNoteExample example);

    int updateByExample(@Param("record") RJobNote record, @Param("example") RJobNoteExample example);
}