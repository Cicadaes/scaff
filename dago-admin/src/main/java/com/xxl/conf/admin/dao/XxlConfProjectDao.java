package com.xxl.conf.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xxl.conf.admin.core.model.XxlConfProject;

/**
 * Created by xuxueli on 16/10/8.
 */
@Mapper
public interface XxlConfProjectDao {

    public List<XxlConfProject> findAll();

    public int save(XxlConfProject xxlConfProject);

    public int update(XxlConfProject xxlConfProject);

    public int delete(@Param("appname") String appname);

    public XxlConfProject load(@Param("appname") String appname);

}