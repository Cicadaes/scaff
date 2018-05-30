package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_value
 * @author 
 */
public class RValue implements Serializable {
    private Long idValue;

    private String name;

    private String valueType;

    private String valueStr;

    private Boolean isNull;

    private static final long serialVersionUID = 1L;

    public Long getIdValue() {
        return idValue;
    }

    public void setIdValue(Long idValue) {
        this.idValue = idValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getValueStr() {
        return valueStr;
    }

    public void setValueStr(String valueStr) {
        this.valueStr = valueStr;
    }

    public Boolean getIsNull() {
        return isNull;
    }

    public void setIsNull(Boolean isNull) {
        this.isNull = isNull;
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
        RValue other = (RValue) that;
        return (this.getIdValue() == null ? other.getIdValue() == null : this.getIdValue().equals(other.getIdValue()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getValueType() == null ? other.getValueType() == null : this.getValueType().equals(other.getValueType()))
            && (this.getValueStr() == null ? other.getValueStr() == null : this.getValueStr().equals(other.getValueStr()))
            && (this.getIsNull() == null ? other.getIsNull() == null : this.getIsNull().equals(other.getIsNull()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdValue() == null) ? 0 : getIdValue().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getValueType() == null) ? 0 : getValueType().hashCode());
        result = prime * result + ((getValueStr() == null) ? 0 : getValueStr().hashCode());
        result = prime * result + ((getIsNull() == null) ? 0 : getIsNull().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idValue=").append(idValue);
        sb.append(", name=").append(name);
        sb.append(", valueType=").append(valueType);
        sb.append(", valueStr=").append(valueStr);
        sb.append(", isNull=").append(isNull);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}