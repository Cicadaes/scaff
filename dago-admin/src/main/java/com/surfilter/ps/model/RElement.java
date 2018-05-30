package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_element
 * @author 
 */
public class RElement implements Serializable {
    private Long idElement;

    private Integer idElementType;

    private String name;

    private static final long serialVersionUID = 1L;

    public Long getIdElement() {
        return idElement;
    }

    public void setIdElement(Long idElement) {
        this.idElement = idElement;
    }

    public Integer getIdElementType() {
        return idElementType;
    }

    public void setIdElementType(Integer idElementType) {
        this.idElementType = idElementType;
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
        RElement other = (RElement) that;
        return (this.getIdElement() == null ? other.getIdElement() == null : this.getIdElement().equals(other.getIdElement()))
            && (this.getIdElementType() == null ? other.getIdElementType() == null : this.getIdElementType().equals(other.getIdElementType()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdElement() == null) ? 0 : getIdElement().hashCode());
        result = prime * result + ((getIdElementType() == null) ? 0 : getIdElementType().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idElement=").append(idElement);
        sb.append(", idElementType=").append(idElementType);
        sb.append(", name=").append(name);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}