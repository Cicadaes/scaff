package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_element_type
 * @author 
 */
public class RElementTypeWithBLOBs extends RElementType implements Serializable {
    private String name;

    private String description;

    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        RElementTypeWithBLOBs other = (RElementTypeWithBLOBs) that;
        return (this.getIdElementType() == null ? other.getIdElementType() == null : this.getIdElementType().equals(other.getIdElementType()))
            && (this.getIdNamespace() == null ? other.getIdNamespace() == null : this.getIdNamespace().equals(other.getIdNamespace()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdElementType() == null) ? 0 : getIdElementType().hashCode());
        result = prime * result + ((getIdNamespace() == null) ? 0 : getIdNamespace().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}