package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_trans_attribute
 * @author 
 */
public class RTransAttribute implements Serializable {
    private Long idTransAttribute;

    private Integer idTransformation;

    private Integer nr;

    private String code;

    private Long valueNum;

    private String valueStr;

    private static final long serialVersionUID = 1L;

    public Long getIdTransAttribute() {
        return idTransAttribute;
    }

    public void setIdTransAttribute(Long idTransAttribute) {
        this.idTransAttribute = idTransAttribute;
    }

    public Integer getIdTransformation() {
        return idTransformation;
    }

    public void setIdTransformation(Integer idTransformation) {
        this.idTransformation = idTransformation;
    }

    public Integer getNr() {
        return nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getValueNum() {
        return valueNum;
    }

    public void setValueNum(Long valueNum) {
        this.valueNum = valueNum;
    }

    public String getValueStr() {
        return valueStr;
    }

    public void setValueStr(String valueStr) {
        this.valueStr = valueStr;
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
        RTransAttribute other = (RTransAttribute) that;
        return (this.getIdTransAttribute() == null ? other.getIdTransAttribute() == null : this.getIdTransAttribute().equals(other.getIdTransAttribute()))
            && (this.getIdTransformation() == null ? other.getIdTransformation() == null : this.getIdTransformation().equals(other.getIdTransformation()))
            && (this.getNr() == null ? other.getNr() == null : this.getNr().equals(other.getNr()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getValueNum() == null ? other.getValueNum() == null : this.getValueNum().equals(other.getValueNum()))
            && (this.getValueStr() == null ? other.getValueStr() == null : this.getValueStr().equals(other.getValueStr()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdTransAttribute() == null) ? 0 : getIdTransAttribute().hashCode());
        result = prime * result + ((getIdTransformation() == null) ? 0 : getIdTransformation().hashCode());
        result = prime * result + ((getNr() == null) ? 0 : getNr().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getValueNum() == null) ? 0 : getValueNum().hashCode());
        result = prime * result + ((getValueStr() == null) ? 0 : getValueStr().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idTransAttribute=").append(idTransAttribute);
        sb.append(", idTransformation=").append(idTransformation);
        sb.append(", nr=").append(nr);
        sb.append(", code=").append(code);
        sb.append(", valueNum=").append(valueNum);
        sb.append(", valueStr=").append(valueStr);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}