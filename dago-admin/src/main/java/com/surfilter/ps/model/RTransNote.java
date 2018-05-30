package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_trans_note
 * @author 
 */
public class RTransNote implements Serializable {
    private Integer idTransformation;

    private Integer idNote;

    private static final long serialVersionUID = 1L;

    public Integer getIdTransformation() {
        return idTransformation;
    }

    public void setIdTransformation(Integer idTransformation) {
        this.idTransformation = idTransformation;
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
        RTransNote other = (RTransNote) that;
        return (this.getIdTransformation() == null ? other.getIdTransformation() == null : this.getIdTransformation().equals(other.getIdTransformation()))
            && (this.getIdNote() == null ? other.getIdNote() == null : this.getIdNote().equals(other.getIdNote()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdTransformation() == null) ? 0 : getIdTransformation().hashCode());
        result = prime * result + ((getIdNote() == null) ? 0 : getIdNote().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idTransformation=").append(idTransformation);
        sb.append(", idNote=").append(idNote);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}