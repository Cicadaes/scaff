package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_jobentry_type
 * @author 
 */
public class RJobentryType implements Serializable {
    private Long idJobentryType;

    private String code;

    private String description;

    private static final long serialVersionUID = 1L;

    public Long getIdJobentryType() {
        return idJobentryType;
    }

    public void setIdJobentryType(Long idJobentryType) {
        this.idJobentryType = idJobentryType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        RJobentryType other = (RJobentryType) that;
        return (this.getIdJobentryType() == null ? other.getIdJobentryType() == null : this.getIdJobentryType().equals(other.getIdJobentryType()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdJobentryType() == null) ? 0 : getIdJobentryType().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idJobentryType=").append(idJobentryType);
        sb.append(", code=").append(code);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}