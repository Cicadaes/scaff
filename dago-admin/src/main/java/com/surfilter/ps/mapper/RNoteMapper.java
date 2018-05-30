package com.surfilter.ps.mapper;

import com.surfilter.ps.model.RNote;
import com.surfilter.ps.model.RNoteExample;
import com.surfilter.ps.model.RNoteWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RNoteMapper {
    long countByExample(RNoteExample example);

    int deleteByExample(RNoteExample example);

    int deleteByPrimaryKey(Long idNote);

    int insert(RNoteWithBLOBs record);

    int insertSelective(RNoteWithBLOBs record);

    List<RNoteWithBLOBs> selectByExampleWithBLOBs(RNoteExample example);

    List<RNote> selectByExample(RNoteExample example);

    RNoteWithBLOBs selectByPrimaryKey(Long idNote);

    int updateByExampleSelective(@Param("record") RNoteWithBLOBs record, @Param("example") RNoteExample example);

    int updateByExampleWithBLOBs(@Param("record") RNoteWithBLOBs record, @Param("example") RNoteExample example);

    int updateByExample(@Param("record") RNote record, @Param("example") RNoteExample example);

    int updateByPrimaryKeySelective(RNoteWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RNoteWithBLOBs record);

    int updateByPrimaryKey(RNote record);
}