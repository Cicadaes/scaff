package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_trans_step_condition
 * @author 
 */
public class RTransStepCondition implements Serializable {
    private Integer idTransformation;

    private Integer idStep;

    private Integer idCondition;

    private static final long serialVersionUID = 1L;

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

    public Integer getIdCondition() {
        return idCondition;
    }

    public void setIdCondition(Integer idCondition) {
        this.idCondition = idCondition;
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
        RTransStepCondition other = (RTransStepCondition) that;
        return (this.getIdTransformation() == null ? other.getIdTransformation() == null : this.getIdTransformation().equals(other.getIdTransformation()))
            && (this.getIdStep() == null ? other.getIdStep() == null : this.getIdStep().equals(other.getIdStep()))
            && (this.getIdCondition() == null ? other.getIdCondition() == null : this.getIdCondition().equals(other.getIdCondition()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdTransformation() == null) ? 0 : getIdTransformation().hashCode());
        result = prime * result + ((getIdStep() == null) ? 0 : getIdStep().hashCode());
        result = prime * result + ((getIdCondition() == null) ? 0 : getIdCondition().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idTransformation=").append(idTransformation);
        sb.append(", idStep=").append(idStep);
        sb.append(", idCondition=").append(idCondition);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}