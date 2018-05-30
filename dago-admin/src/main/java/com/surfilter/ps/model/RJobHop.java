package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_job_hop
 * @author 
 */
public class RJobHop implements Serializable {
    private Long idJobHop;

    private Integer idJob;

    private Integer idJobentryCopyFrom;

    private Integer idJobentryCopyTo;

    private Boolean enabled;

    private Boolean evaluation;

    private Boolean unconditional;

    private static final long serialVersionUID = 1L;

    public Long getIdJobHop() {
        return idJobHop;
    }

    public void setIdJobHop(Long idJobHop) {
        this.idJobHop = idJobHop;
    }

    public Integer getIdJob() {
        return idJob;
    }

    public void setIdJob(Integer idJob) {
        this.idJob = idJob;
    }

    public Integer getIdJobentryCopyFrom() {
        return idJobentryCopyFrom;
    }

    public void setIdJobentryCopyFrom(Integer idJobentryCopyFrom) {
        this.idJobentryCopyFrom = idJobentryCopyFrom;
    }

    public Integer getIdJobentryCopyTo() {
        return idJobentryCopyTo;
    }

    public void setIdJobentryCopyTo(Integer idJobentryCopyTo) {
        this.idJobentryCopyTo = idJobentryCopyTo;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Boolean evaluation) {
        this.evaluation = evaluation;
    }

    public Boolean getUnconditional() {
        return unconditional;
    }

    public void setUnconditional(Boolean unconditional) {
        this.unconditional = unconditional;
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
        RJobHop other = (RJobHop) that;
        return (this.getIdJobHop() == null ? other.getIdJobHop() == null : this.getIdJobHop().equals(other.getIdJobHop()))
            && (this.getIdJob() == null ? other.getIdJob() == null : this.getIdJob().equals(other.getIdJob()))
            && (this.getIdJobentryCopyFrom() == null ? other.getIdJobentryCopyFrom() == null : this.getIdJobentryCopyFrom().equals(other.getIdJobentryCopyFrom()))
            && (this.getIdJobentryCopyTo() == null ? other.getIdJobentryCopyTo() == null : this.getIdJobentryCopyTo().equals(other.getIdJobentryCopyTo()))
            && (this.getEnabled() == null ? other.getEnabled() == null : this.getEnabled().equals(other.getEnabled()))
            && (this.getEvaluation() == null ? other.getEvaluation() == null : this.getEvaluation().equals(other.getEvaluation()))
            && (this.getUnconditional() == null ? other.getUnconditional() == null : this.getUnconditional().equals(other.getUnconditional()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdJobHop() == null) ? 0 : getIdJobHop().hashCode());
        result = prime * result + ((getIdJob() == null) ? 0 : getIdJob().hashCode());
        result = prime * result + ((getIdJobentryCopyFrom() == null) ? 0 : getIdJobentryCopyFrom().hashCode());
        result = prime * result + ((getIdJobentryCopyTo() == null) ? 0 : getIdJobentryCopyTo().hashCode());
        result = prime * result + ((getEnabled() == null) ? 0 : getEnabled().hashCode());
        result = prime * result + ((getEvaluation() == null) ? 0 : getEvaluation().hashCode());
        result = prime * result + ((getUnconditional() == null) ? 0 : getUnconditional().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idJobHop=").append(idJobHop);
        sb.append(", idJob=").append(idJob);
        sb.append(", idJobentryCopyFrom=").append(idJobentryCopyFrom);
        sb.append(", idJobentryCopyTo=").append(idJobentryCopyTo);
        sb.append(", enabled=").append(enabled);
        sb.append(", evaluation=").append(evaluation);
        sb.append(", unconditional=").append(unconditional);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}