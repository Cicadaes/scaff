package com.surfilter.ps.system.entity;

import java.util.Date;
import java.util.List;

import com.surfilter.ps.core.entity.PageEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @ClassName: Dict.java
 * @Description: Company: surfilter.com
 * @author xuxiaolong
 * @date 2018年5月2日
 */
@ApiModel(value = "Dict", description = "字典信息")
public class Dict extends PageEntity {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "类型", required = true)
	private String type; // 类型

	@ApiModelProperty(value = "名称", required = true)
	private String name; // 名称

	@ApiModelProperty(value = "值", required = true)
	private String value; // 值

	@ApiModelProperty(value = "描述", required = false)
	private String desc;

	@ApiModelProperty(value = "顺序", required = false)
	private Long order;

	@ApiModelProperty(value = "更新时间", required = false)
	private Date updateTime;

	@ApiModelProperty(value = "备用字段", hidden = true)
	private String extend1; // 备用字段

	@ApiModelProperty(value = "子列表", hidden = true)
	private List<Dict> childList; // 子列表

	public String getExtend1() {
		return extend1;
	}

	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public List<Dict> getChildList() {
		return childList;
	}

	public void setChildList(List<Dict> childList) {
		this.childList = childList;
	}

	public Long getOrder() {
		return order;
	}

	public void setOrder(Long order) {
		this.order = order;
	}

}
