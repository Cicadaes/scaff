package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_jobentry
 * @author 
 */
public class RJobentry implements Serializable {
    private Long idJobentry;

    private Integer idJob;

    private Integer idJobentryType;

    private String name;

    private String description;

    private static final long serialVersionUID = 1L;

    public Long getIdJobentry() {
        return idJobentry;
    }

    public void setIdJobentry(Long idJobentry) {
        this.idJobentry = idJobentry;
    }

    public Integer getIdJob() {
        return idJob;
    }

    public void setIdJob(Integer idJob) {
        this.idJob = idJob;
    }

    public Integer getIdJobentryType() {
        return idJobentryType;
    }

    public void setIdJobentryType(Integer idJobentryType) {
        this.idJobentryType = idJobentryType;
    }

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
        RJobentry other = (RJobentry) that;
        return (this.getIdJobentry() == null ? other.getIdJobentry() == null : this.getIdJobentry().equals(other.getIdJobentry()))
            && (this.getIdJob() == null ? other.getIdJob() == null : this.getIdJob().equals(other.getIdJob()))
            && (this.getIdJobentryType() == null ? other.getIdJobentryType() == null : this.getIdJobentryType().equals(other.getIdJobentryType()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdJobentry() == null) ? 0 : getIdJobentry().hashCode());
        result = prime * result + ((getIdJob() == null) ? 0 : getIdJob().hashCode());
        result = prime * result + ((getIdJobentryType() == null) ? 0 : getIdJobentryType().hashCode());
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
        sb.append(", idJobentry=").append(idJobentry);
        sb.append(", idJob=").append(idJob);
        sb.append(", idJobentryType=").append(idJobentryType);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}