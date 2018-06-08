package com.surfilter.ps.core.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName: PageEntity
 * @Description: 分页工具
 * @author 金凡
 * @date 2018-04-09
 */
@ApiModel(value = "PageEntity", description = "分页信息")
public abstract class PageEntity implements Serializable{
	
	private static final long serialVersionUID = 4837423784764922707L;
	
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@ApiModelProperty(value = "每页开始记录（默认为0）")
	protected Integer start = 0;
	
	@ApiModelProperty(value = "每页记录数（默认为20）")
	protected Integer size = 20 ;
	
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
}
