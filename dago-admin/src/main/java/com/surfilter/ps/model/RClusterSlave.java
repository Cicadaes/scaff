package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_cluster_slave
 * @author 
 */
public class RClusterSlave implements Serializable {
    private Long idClusterSlave;

    private Integer idCluster;

    private Integer idSlave;

    private static final long serialVersionUID = 1L;

    public Long getIdClusterSlave() {
        return idClusterSlave;
    }

    public void setIdClusterSlave(Long idClusterSlave) {
        this.idClusterSlave = idClusterSlave;
    }

    public Integer getIdCluster() {
        return idCluster;
    }

    public void setIdCluster(Integer idCluster) {
        this.idCluster = idCluster;
    }

    public Integer getIdSlave() {
        return idSlave;
    }

    public void setIdSlave(Integer idSlave) {
        this.idSlave = idSlave;
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
        RClusterSlave other = (RClusterSlave) that;
        return (this.getIdClusterSlave() == null ? other.getIdClusterSlave() == null : this.getIdClusterSlave().equals(other.getIdClusterSlave()))
            && (this.getIdCluster() == null ? other.getIdCluster() == null : this.getIdCluster().equals(other.getIdCluster()))
            && (this.getIdSlave() == null ? other.getIdSlave() == null : this.getIdSlave().equals(other.getIdSlave()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdClusterSlave() == null) ? 0 : getIdClusterSlave().hashCode());
        result = prime * result + ((getIdCluster() == null) ? 0 : getIdCluster().hashCode());
        result = prime * result + ((getIdSlave() == null) ? 0 : getIdSlave().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idClusterSlave=").append(idClusterSlave);
        sb.append(", idCluster=").append(idCluster);
        sb.append(", idSlave=").append(idSlave);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}