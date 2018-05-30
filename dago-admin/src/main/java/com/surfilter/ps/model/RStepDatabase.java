package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_step_database
 * @author 
 */
public class RStepDatabase implements Serializable {
    private Integer idTransformation;

    private Integer idStep;

    private Integer idDatabase;

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

    public Integer getIdDatabase() {
        return idDatabase;
    }

    public void setIdDatabase(Integer idDatabase) {
        this.idDatabase = idDatabase;
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
        RStepDatabase other = (RStepDatabase) that;
        return (this.getIdTransformation() == null ? other.getIdTransformation() == null : this.getIdTransformation().equals(other.getIdTransformation()))
            && (this.getIdStep() == null ? other.getIdStep() == null : this.getIdStep().equals(other.getIdStep()))
            && (this.getIdDatabase() == null ? other.getIdDatabase() == null : this.getIdDatabase().equals(other.getIdDatabase()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdTransformation() == null) ? 0 : getIdTransformation().hashCode());
        result = prime * result + ((getIdStep() == null) ? 0 : getIdStep().hashCode());
        result = prime * result + ((getIdDatabase() == null) ? 0 : getIdDatabase().hashCode());
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
        sb.append(", idDatabase=").append(idDatabase);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}