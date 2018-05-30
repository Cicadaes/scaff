package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_trans_cluster
 * @author 
 */
public class RTransCluster implements Serializable {
    private Long idTransCluster;

    private Integer idTransformation;

    private Integer idCluster;

    private static final long serialVersionUID = 1L;

    public Long getIdTransCluster() {
        return idTransCluster;
    }

    public void setIdTransCluster(Long idTransCluster) {
        this.idTransCluster = idTransCluster;
    }

    public Integer getIdTransformation() {
        return idTransformation;
    }

    public void setIdTransformation(Integer idTransformation) {
        this.idTransformation = idTransformation;
    }

    public Integer getIdCluster() {
        return idCluster;
    }

    public void setIdCluster(Integer idCluster) {
        this.idCluster = idCluster;
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
        RTransCluster other = (RTransCluster) that;
        return (this.getIdTransCluster() == null ? other.getIdTransCluster() == null : this.getIdTransCluster().equals(other.getIdTransCluster()))
            && (this.getIdTransformation() == null ? other.getIdTransformation() == null : this.getIdTransformation().equals(other.getIdTransformation()))
            && (this.getIdCluster() == null ? other.getIdCluster() == null : this.getIdCluster().equals(other.getIdCluster()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdTransCluster() == null) ? 0 : getIdTransCluster().hashCode());
        result = prime * result + ((getIdTransformation() == null) ? 0 : getIdTransformation().hashCode());
        result = prime * result + ((getIdCluster() == null) ? 0 : getIdCluster().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idTransCluster=").append(idTransCluster);
        sb.append(", idTransformation=").append(idTransformation);
        sb.append(", idCluster=").append(idCluster);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}