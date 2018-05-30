package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_jobentry_database
 * @author 
 */
public class RJobentryDatabase implements Serializable {
    private Integer idJob;

    private Integer idJobentry;

    private Integer idDatabase;

    private static final long serialVersionUID = 1L;

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
        RJobentryDatabase other = (RJobentryDatabase) that;
        return (this.getIdJob() == null ? other.getIdJob() == null : this.getIdJob().equals(other.getIdJob()))
            && (this.getIdJobentry() == null ? other.getIdJobentry() == null : this.getIdJobentry().equals(other.getIdJobentry()))
            && (this.getIdDatabase() == null ? other.getIdDatabase() == null : this.getIdDatabase().equals(other.getIdDatabase()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdJob() == null) ? 0 : getIdJob().hashCode());
        result = prime * result + ((getIdJobentry() == null) ? 0 : getIdJobentry().hashCode());
        result = prime * result + ((getIdDatabase() == null) ? 0 : getIdDatabase().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idJob=").append(idJob);
        sb.append(", idJobentry=").append(idJobentry);
        sb.append(", idDatabase=").append(idDatabase);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}