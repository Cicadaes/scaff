package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_jobentry_attribute
 * @author 
 */
public class RJobentryAttribute implements Serializable {
    private Long idJobentryAttribute;

    private Integer idJob;

    private Integer idJobentry;

    private Integer nr;

    private String code;

    private Double valueNum;

    private String valueStr;

    private static final long serialVersionUID = 1L;

    public Long getIdJobentryAttribute() {
        return idJobentryAttribute;
    }

    public void setIdJobentryAttribute(Long idJobentryAttribute) {
        this.idJobentryAttribute = idJobentryAttribute;
    }

    public Integer getIdJob() {
        return idJob;
    }

    public void setIdJob(Integer idJob) {
        this.idJob = idJob;
    }

    public Integer getIdJobentry() {
        return idJobentry;
    }

    public void setIdJobentry(Integer idJobentry) {
        this.idJobentry = idJobentry;
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

    public Double getValueNum() {
        return valueNum;
    }

    public void setValueNum(Double valueNum) {
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
        RJobentryAttribute other = (RJobentryAttribute) that;
        return (this.getIdJobentryAttribute() == null ? other.getIdJobentryAttribute() == null : this.getIdJobentryAttribute().equals(other.getIdJobentryAttribute()))
            && (this.getIdJob() == null ? other.getIdJob() == null : this.getIdJob().equals(other.getIdJob()))
            && (this.getIdJobentry() == null ? other.getIdJobentry() == null : this.getIdJobentry().equals(other.getIdJobentry()))
            && (this.getNr() == null ? other.getNr() == null : this.getNr().equals(other.getNr()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getValueNum() == null ? other.getValueNum() == null : this.getValueNum().equals(other.getValueNum()))
            && (this.getValueStr() == null ? other.getValueStr() == null : this.getValueStr().equals(other.getValueStr()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdJobentryAttribute() == null) ? 0 : getIdJobentryAttribute().hashCode());
        result = prime * result + ((getIdJob() == null) ? 0 : getIdJob().hashCode());
        result = prime * result + ((getIdJobentry() == null) ? 0 : getIdJobentry().hashCode());
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
        sb.append(", idJobentryAttribute=").append(idJobentryAttribute);
        sb.append(", idJob=").append(idJob);
        sb.append(", idJobentry=").append(idJobentry);
        sb.append(", nr=").append(nr);
        sb.append(", code=").append(code);
        sb.append(", valueNum=").append(valueNum);
        sb.append(", valueStr=").append(valueStr);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}