package com.surfilter.ps.model;

import java.io.Serializable;
import java.util.Date;

/**
 * r_trans_lock
 * @author 
 */
public class RTransLock implements Serializable {
    private Long idTransLock;

    private Integer idTransformation;

    private Integer idUser;

    private Date lockDate;

    private String lockMessage;

    private static final long serialVersionUID = 1L;

    public Long getIdTransLock() {
        return idTransLock;
    }

    public void setIdTransLock(Long idTransLock) {
        this.idTransLock = idTransLock;
    }

    public Integer getIdTransformation() {
        return idTransformation;
    }

    public void setIdTransformation(Integer idTransformation) {
        this.idTransformation = idTransformation;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Date getLockDate() {
        return lockDate;
    }

    public void setLockDate(Date lockDate) {
        this.lockDate = lockDate;
    }

    public String getLockMessage() {
        return lockMessage;
    }

    public void setLockMessage(String lockMessage) {
        this.lockMessage = lockMessage;
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
        RTransLock other = (RTransLock) that;
        return (this.getIdTransLock() == null ? other.getIdTransLock() == null : this.getIdTransLock().equals(other.getIdTransLock()))
            && (this.getIdTransformation() == null ? other.getIdTransformation() == null : this.getIdTransformation().equals(other.getIdTransformation()))
            && (this.getIdUser() == null ? other.getIdUser() == null : this.getIdUser().equals(other.getIdUser()))
            && (this.getLockDate() == null ? other.getLockDate() == null : this.getLockDate().equals(other.getLockDate()))
            && (this.getLockMessage() == null ? other.getLockMessage() == null : this.getLockMessage().equals(other.getLockMessage()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdTransLock() == null) ? 0 : getIdTransLock().hashCode());
        result = prime * result + ((getIdTransformation() == null) ? 0 : getIdTransformation().hashCode());
        result = prime * result + ((getIdUser() == null) ? 0 : getIdUser().hashCode());
        result = prime * result + ((getLockDate() == null) ? 0 : getLockDate().hashCode());
        result = prime * result + ((getLockMessage() == null) ? 0 : getLockMessage().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idTransLock=").append(idTransLock);
        sb.append(", idTransformation=").append(idTransformation);
        sb.append(", idUser=").append(idUser);
        sb.append(", lockDate=").append(lockDate);
        sb.append(", lockMessage=").append(lockMessage);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}