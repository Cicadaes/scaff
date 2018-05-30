package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_job_note
 * @author 
 */
public class RJobNote implements Serializable {
    private Integer idJob;

    private Integer idNote;

    private static final long serialVersionUID = 1L;

    public Integer getIdJob() {
        return idJob;
    }

    public void setIdJob(Integer idJob) {
        this.idJob = idJob;
    }

    public Integer getIdNote() {
        return idNote;
    }

    public void setIdNote(Integer idNote) {
        this.idNote = idNote;
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
        RJobNote other = (RJobNote) that;
        return (this.getIdJob() == null ? other.getIdJob() == null : this.getIdJob().equals(other.getIdJob()))
            && (this.getIdNote() == null ? other.getIdNote() == null : this.getIdNote().equals(other.getIdNote()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdJob() == null) ? 0 : getIdJob().hashCode());
        result = prime * result + ((getIdNote() == null) ? 0 : getIdNote().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idJob=").append(idJob);
        sb.append(", idNote=").append(idNote);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}