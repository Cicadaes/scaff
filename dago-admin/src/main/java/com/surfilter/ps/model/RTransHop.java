package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_trans_hop
 * @author 
 */
public class RTransHop implements Serializable {
    private Long idTransHop;

    private Integer idTransformation;

    private Integer idStepFrom;

    private Integer idStepTo;

    private Boolean enabled;

    private static final long serialVersionUID = 1L;

    public Long getIdTransHop() {
        return idTransHop;
    }

    public void setIdTransHop(Long idTransHop) {
        this.idTransHop = idTransHop;
    }

    public Integer getIdTransformation() {
        return idTransformation;
    }

    public void setIdTransformation(Integer idTransformation) {
        this.idTransformation = idTransformation;
    }

    public Integer getIdStepFrom() {
        return idStepFrom;
    }

    public void setIdStepFrom(Integer idStepFrom) {
        this.idStepFrom = idStepFrom;
    }

    public Integer getIdStepTo() {
        return idStepTo;
    }

    public void setIdStepTo(Integer idStepTo) {
        this.idStepTo = idStepTo;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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
        RTransHop other = (RTransHop) that;
        return (this.getIdTransHop() == null ? other.getIdTransHop() == null : this.getIdTransHop().equals(other.getIdTransHop()))
            && (this.getIdTransformation() == null ? other.getIdTransformation() == null : this.getIdTransformation().equals(other.getIdTransformation()))
            && (this.getIdStepFrom() == null ? other.getIdStepFrom() == null : this.getIdStepFrom().equals(other.getIdStepFrom()))
            && (this.getIdStepTo() == null ? other.getIdStepTo() == null : this.getIdStepTo().equals(other.getIdStepTo()))
            && (this.getEnabled() == null ? other.getEnabled() == null : this.getEnabled().equals(other.getEnabled()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdTransHop() == null) ? 0 : getIdTransHop().hashCode());
        result = prime * result + ((getIdTransformation() == null) ? 0 : getIdTransformation().hashCode());
        result = prime * result + ((getIdStepFrom() == null) ? 0 : getIdStepFrom().hashCode());
        result = prime * result + ((getIdStepTo() == null) ? 0 : getIdStepTo().hashCode());
        result = prime * result + ((getEnabled() == null) ? 0 : getEnabled().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idTransHop=").append(idTransHop);
        sb.append(", idTransformation=").append(idTransformation);
        sb.append(", idStepFrom=").append(idStepFrom);
        sb.append(", idStepTo=").append(idStepTo);
        sb.append(", enabled=").append(enabled);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}