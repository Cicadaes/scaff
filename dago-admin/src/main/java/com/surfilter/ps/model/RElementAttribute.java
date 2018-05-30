package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_element_attribute
 * @author 
 */
public class RElementAttribute implements Serializable {
    private Long idElementAttribute;

    private Integer idElement;

    private Integer idElementAttributeParent;

    private String attrKey;

    private String attrValue;

    private static final long serialVersionUID = 1L;

    public Long getIdElementAttribute() {
        return idElementAttribute;
    }

    public void setIdElementAttribute(Long idElementAttribute) {
        this.idElementAttribute = idElementAttribute;
    }

    public Integer getIdElement() {
        return idElement;
    }

    public void setIdElement(Integer idElement) {
        this.idElement = idElement;
    }

    public Integer getIdElementAttributeParent() {
        return idElementAttributeParent;
    }

    public void setIdElementAttributeParent(Integer idElementAttributeParent) {
        this.idElementAttributeParent = idElementAttributeParent;
    }

    public String getAttrKey() {
        return attrKey;
    }

    public void setAttrKey(String attrKey) {
        this.attrKey = attrKey;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
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
        RElementAttribute other = (RElementAttribute) that;
        return (this.getIdElementAttribute() == null ? other.getIdElementAttribute() == null : this.getIdElementAttribute().equals(other.getIdElementAttribute()))
            && (this.getIdElement() == null ? other.getIdElement() == null : this.getIdElement().equals(other.getIdElement()))
            && (this.getIdElementAttributeParent() == null ? other.getIdElementAttributeParent() == null : this.getIdElementAttributeParent().equals(other.getIdElementAttributeParent()))
            && (this.getAttrKey() == null ? other.getAttrKey() == null : this.getAttrKey().equals(other.getAttrKey()))
            && (this.getAttrValue() == null ? other.getAttrValue() == null : this.getAttrValue().equals(other.getAttrValue()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdElementAttribute() == null) ? 0 : getIdElementAttribute().hashCode());
        result = prime * result + ((getIdElement() == null) ? 0 : getIdElement().hashCode());
        result = prime * result + ((getIdElementAttributeParent() == null) ? 0 : getIdElementAttributeParent().hashCode());
        result = prime * result + ((getAttrKey() == null) ? 0 : getAttrKey().hashCode());
        result = prime * result + ((getAttrValue() == null) ? 0 : getAttrValue().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idElementAttribute=").append(idElementAttribute);
        sb.append(", idElement=").append(idElement);
        sb.append(", idElementAttributeParent=").append(idElementAttributeParent);
        sb.append(", attrKey=").append(attrKey);
        sb.append(", attrValue=").append(attrValue);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}