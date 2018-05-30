package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_namespace
 * @author 
 */
public class RNamespace implements Serializable {
    private Long idNamespace;

    private String name;

    private static final long serialVersionUID = 1L;

    public Long getIdNamespace() {
        return idNamespace;
    }

    public void setIdNamespace(Long idNamespace) {
        this.idNamespace = idNamespace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        RNamespace other = (RNamespace) that;
        return (this.getIdNamespace() == null ? other.getIdNamespace() == null : this.getIdNamespace().equals(other.getIdNamespace()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdNamespace() == null) ? 0 : getIdNamespace().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idNamespace=").append(idNamespace);
        sb.append(", name=").append(name);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}