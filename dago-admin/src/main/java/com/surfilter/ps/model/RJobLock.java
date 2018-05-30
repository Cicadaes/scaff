package com.surfilter.ps.model;

import java.io.Serializable;
import java.util.Date;

/**
 * r_job_lock
 * @author 
 */
public class RJobLock implements Serializable {
    private Long idJobLock;

    private Integer idJob;

    private Integer idUser;

    private Date lockDate;

    private String lockMessage;

    private static final long serialVersionUID = 1L;

    public Long getIdJobLock() {
        return idJobLock;
    }

    public void setIdJobLock(Long idJobLock) {
        this.idJobLock = idJobLock;
    }

    public Integer getIdJob() {
        return idJob;
    }

    public void setIdJob(Integer idJob) {
        this.idJob = idJob;
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
        RJobLock other = (RJobLock) that;
        return (this.getIdJobLock() == null ? other.getIdJobLock() == null : this.getIdJobLock().equals(other.getIdJobLock()))
            && (this.getIdJob() == null ? other.getIdJob() == null : this.getIdJob().equals(other.getIdJob()))
            && (this.getIdUser() == null ? other.getIdUser() == null : this.getIdUser().equals(other.getIdUser()))
            && (this.getLockDate() == null ? other.getLockDate() == null : this.getLockDate().equals(other.getLockDate()))
            && (this.getLockMessage() == null ? other.getLockMessage() == null : this.getLockMessage().equals(other.getLockMessage()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdJobLock() == null) ? 0 : getIdJobLock().hashCode());
        result = prime * result + ((getIdJob() == null) ? 0 : getIdJob().hashCode());
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
        sb.append(", idJobLock=").append(idJobLock);
        sb.append(", idJob=").append(idJob);
        sb.append(", idUser=").append(idUser);
        sb.append(", lockDate=").append(lockDate);
        sb.append(", lockMessage=").append(lockMessage);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}