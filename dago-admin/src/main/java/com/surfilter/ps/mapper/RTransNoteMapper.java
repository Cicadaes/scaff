package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RTransNote;
import com.surfilter.ps.model.RTransNoteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RTransNoteMapper {
    long countByExample(RTransNoteExample example);

    int deleteByExample(RTransNoteExample example);

    int insert(RTransNote record);

    int insertSelective(RTransNote record);

    List<RTransNote> selectByExample(RTransNoteExample example);

    int updateByExampleSelective(@Param("record") RTransNote record, @Param("example") RTransNoteExample example);

    int updateByExample(@Param("record") RTransNote record, @Param("example") RTransNoteExample example);
}