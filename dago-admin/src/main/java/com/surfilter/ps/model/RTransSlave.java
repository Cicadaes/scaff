package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_trans_slave
 * @author 
 */
public class RTransSlave implements Serializable {
    private Long idTransSlave;

    private Integer idTransformation;

    private Integer idSlave;

    private static final long serialVersionUID = 1L;

    public Long getIdTransSlave() {
        return idTransSlave;
    }

    public void setIdTransSlave(Long idTransSlave) {
        this.idTransSlave = idTransSlave;
    }

    public Integer getIdTransformation() {
        return idTransformation;
    }

    public void setIdTransformation(Integer idTransformation) {
        this.idTransformation = idTransformation;
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
        RTransSlave other = (RTransSlave) that;
        return (this.getIdTransSlave() == null ? other.getIdTransSlave() == null : this.getIdTransSlave().equals(other.getIdTransSlave()))
            && (this.getIdTransformation() == null ? other.getIdTransformation() == null : this.getIdTransformation().equals(other.getIdTransformation()))
            && (this.getIdSlave() == null ? other.getIdSlave() == null : this.getIdSlave().equals(other.getIdSlave()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdTransSlave() == null) ? 0 : getIdTransSlave().hashCode());
        result = prime * result + ((getIdTransformation() == null) ? 0 : getIdTransformation().hashCode());
        result = prime * result + ((getIdSlave() == null) ? 0 : getIdSlave().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idTransSlave=").append(idTransSlave);
        sb.append(", idTransformation=").append(idTransformation);
        sb.append(", idSlave=").append(idSlave);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}