package com.surfilter.ps.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * r_cluster
 * 
 * @author
 */
public class RCluster implements Serializable {
	@ApiModelProperty(value="集群id",name="idCluster",example="1")
	private Long idCluster;

	private String name;

	private String basePort;

	private String socketsBufferSize;

	private String socketsFlushInterval;

	private Boolean socketsCompressed;

	private Boolean dynamicCluster;

	private static final long serialVersionUID = 1L;

	public Long getIdCluster() {
		return idCluster;
	}

	public void setIdCluster(Long idCluster) {
		this.idCluster = idCluster;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBasePort() {
		return basePort;
	}

	public void setBasePort(String basePort) {
		this.basePort = basePort;
	}

	public String getSocketsBufferSize() {
		return socketsBufferSize;
	}

	public void setSocketsBufferSize(String socketsBufferSize) {
		this.socketsBufferSize = socketsBufferSize;
	}

	public String getSocketsFlushInterval() {
		return socketsFlushInterval;
	}

	public void setSocketsFlushInterval(String socketsFlushInterval) {
		this.socketsFlushInterval = socketsFlushInterval;
	}

	public Boolean getSocketsCompressed() {
		return socketsCompressed;
	}

	public void setSocketsCompressed(Boolean socketsCompressed) {
		this.socketsCompressed = socketsCompressed;
	}

	public Boolean getDynamicCluster() {
		return dynamicCluster;
	}

	public void setDynamicCluster(Boolean dynamicCluster) {
		this.dynamicCluster = dynamicCluster;
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		RCluster other = (RCluster) that;
		return (this.getIdCluster() == null ? other.getIdCluster() == null
				: this.getIdCluster().equals(other.getIdCluster()))
				&& (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
				&& (this.getBasePort() == null ? other.getBasePort() == null
						: this.getBasePort().equals(other.getBasePort()))
				&& (this.getSocketsBufferSize() == null ? other.getSocketsBufferSize() == null
						: this.getSocketsBufferSize().equals(other.getSocketsBufferSize()))
				&& (this.getSocketsFlushInterval() == null ? other.getSocketsFlushInterval() == null
						: this.getSocketsFlushInterval().equals(other.getSocketsFlushInterval()))
				&& (this.getSocketsCompressed() == null ? other.getSocketsCompressed() == null
						: this.getSocketsCompressed().equals(other.getSocketsCompressed()))
				&& (this.getDynamicCluster() == null ? other.getDynamicCluster() == null
						: this.getDynamicCluster().equals(other.getDynamicCluster()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getIdCluster() == null) ? 0 : getIdCluster().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getBasePort() == null) ? 0 : getBasePort().hashCode());
		result = prime * result + ((getSocketsBufferSize() == null) ? 0 : getSocketsBufferSize().hashCode());
		result = prime * result + ((getSocketsFlushInterval() == null) ? 0 : getSocketsFlushInterval().hashCode());
		result = prime * result + ((getSocketsCompressed() == null) ? 0 : getSocketsCompressed().hashCode());
		result = prime * result + ((getDynamicCluster() == null) ? 0 : getDynamicCluster().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", idCluster=").append(idCluster);
		sb.append(", name=").append(name);
		sb.append(", basePort=").append(basePort);
		sb.append(", socketsBufferSize=").append(socketsBufferSize);
		sb.append(", socketsFlushInterval=").append(socketsFlushInterval);
		sb.append(", socketsCompressed=").append(socketsCompressed);
		sb.append(", dynamicCluster=").append(dynamicCluster);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}