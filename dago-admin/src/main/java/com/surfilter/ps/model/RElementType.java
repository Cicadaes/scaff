package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_element_type
 * @author 
 */
public class RElementType implements Serializable {
    private Long idElementType;

    private Integer idNamespace;

    private static final long serialVersionUID = 1L;

    public Long getIdElementType() {
        return idElementType;
    }

    public void setIdElementType(Long idElementType) {
        this.idElementType = idElementType;
    }

    public Integer getIdNamespace() {
        return idNamespace;
    }

    public void setIdNamespace(Integer idNamespace) {
        this.idNamespace = idNamespace;
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
        RElementType other = (RElementType) that;
        return (this.getIdElementType() == null ? other.getIdElementType() == null : this.getIdElementType().equals(other.getIdElementType()))
            && (this.getIdNamespace() == null ? other.getIdNamespace() == null : this.getIdNamespace().equals(other.getIdNamespace()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdElementType() == null) ? 0 : getIdElementType().hashCode());
        result = prime * result + ((getIdNamespace() == null) ? 0 : getIdNamespace().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idElementType=").append(idElementType);
        sb.append(", idNamespace=").append(idNamespace);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}