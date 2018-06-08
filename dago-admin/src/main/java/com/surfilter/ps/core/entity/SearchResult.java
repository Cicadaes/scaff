package com.surfilter.ps.core.entity;

import java.util.List;

/**
 * @ClassName: SearchResult
 * @Description: es查询结果类
 * @author 金凡
 * @date 2018-04-18
 */
public class SearchResult {

	private long resultCount;
	private List<?> dataList;
	private long costTime;
	private String sql;

	public long getResultCount() {
		return resultCount;
	}

	public void setResultCount(long resultCount) {
		this.resultCount = resultCount;
	}

	public List<?> getDataList() {
		return dataList;
	}

	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public long getCostTime() {
		return costTime;
	}

	public void setCostTime(long costTime) {
		this.costTime = costTime;
	}

}
