package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_step_attribute
 * @author 
 */
public class RStepAttribute implements Serializable {
    private Long idStepAttribute;

    private Integer idTransformation;

    private Integer idStep;

    private Integer nr;

    private String code;

    private Long valueNum;

    private String valueStr;

    private static final long serialVersionUID = 1L;

    public Long getIdStepAttribute() {
        return idStepAttribute;
    }

    public void setIdStepAttribute(Long idStepAttribute) {
        this.idStepAttribute = idStepAttribute;
    }

    public Integer getIdTransformation() {
        return idTransformation;
    }

    public void setIdTransformation(Integer idTransformation) {
        this.idTransformation = idTransformation;
    }

    public Integer getIdStep() {
        return idStep;
    }

    public void setIdStep(Integer idStep) {
        this.idStep = idStep;
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
        RStepAttribute other = (RStepAttribute) that;
        return (this.getIdStepAttribute() == null ? other.getIdStepAttribute() == null : this.getIdStepAttribute().equals(other.getIdStepAttribute()))
            && (this.getIdTransformation() == null ? other.getIdTransformation() == null : this.getIdTransformation().equals(other.getIdTransformation()))
            && (this.getIdStep() == null ? other.getIdStep() == null : this.getIdStep().equals(other.getIdStep()))
            && (this.getNr() == null ? other.getNr() == null : this.getNr().equals(other.getNr()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getValueNum() == null ? other.getValueNum() == null : this.getValueNum().equals(other.getValueNum()))
            && (this.getValueStr() == null ? other.getValueStr() == null : this.getValueStr().equals(other.getValueStr()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdStepAttribute() == null) ? 0 : getIdStepAttribute().hashCode());
        result = prime * result + ((getIdTransformation() == null) ? 0 : getIdTransformation().hashCode());
        result = prime * result + ((getIdStep() == null) ? 0 : getIdStep().hashCode());
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
        sb.append(", idStepAttribute=").append(idStepAttribute);
        sb.append(", idTransformation=").append(idTransformation);
        sb.append(", idStep=").append(idStep);
        sb.append(", nr=").append(nr);
        sb.append(", code=").append(code);
        sb.append(", valueNum=").append(valueNum);
        sb.append(", valueStr=").append(valueStr);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}