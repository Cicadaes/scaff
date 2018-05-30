package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_job_attribute
 * @author 
 */
public class RJobAttribute implements Serializable {
    private Long idJobAttribute;

    private Integer idJob;

    private Integer nr;

    private String code;

    private Long valueNum;

    private String valueStr;

    private static final long serialVersionUID = 1L;

    public Long getIdJobAttribute() {
        return idJobAttribute;
    }

    public void setIdJobAttribute(Long idJobAttribute) {
        this.idJobAttribute = idJobAttribute;
    }

    public Integer getIdJob() {
        return idJob;
    }

    public void setIdJob(Integer idJob) {
        this.idJob = idJob;
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
        RJobAttribute other = (RJobAttribute) that;
        return (this.getIdJobAttribute() == null ? other.getIdJobAttribute() == null : this.getIdJobAttribute().equals(other.getIdJobAttribute()))
            && (this.getIdJob() == null ? other.getIdJob() == null : this.getIdJob().equals(other.getIdJob()))
            && (this.getNr() == null ? other.getNr() == null : this.getNr().equals(other.getNr()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getValueNum() == null ? other.getValueNum() == null : this.getValueNum().equals(other.getValueNum()))
            && (this.getValueStr() == null ? other.getValueStr() == null : this.getValueStr().equals(other.getValueStr()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdJobAttribute() == null) ? 0 : getIdJobAttribute().hashCode());
        result = prime * result + ((getIdJob() == null) ? 0 : getIdJob().hashCode());
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
        sb.append(", idJobAttribute=").append(idJobAttribute);
        sb.append(", idJob=").append(idJob);
        sb.append(", nr=").append(nr);
        sb.append(", code=").append(code);
        sb.append(", valueNum=").append(valueNum);
        sb.append(", valueStr=").append(valueStr);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}