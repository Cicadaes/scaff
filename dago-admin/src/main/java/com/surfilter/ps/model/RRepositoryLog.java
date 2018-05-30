package com.surfilter.ps.model;

import java.io.Serializable;
import java.util.Date;

/**
 * r_repository_log
 * @author 
 */
public class RRepositoryLog implements Serializable {
    private Long idRepositoryLog;

    private String repVersion;

    private Date logDate;

    private String logUser;

    private String operationDesc;

    private static final long serialVersionUID = 1L;

    public Long getIdRepositoryLog() {
        return idRepositoryLog;
    }

    public void setIdRepositoryLog(Long idRepositoryLog) {
        this.idRepositoryLog = idRepositoryLog;
    }

    public String getRepVersion() {
        return repVersion;
    }

    public void setRepVersion(String repVersion) {
        this.repVersion = repVersion;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getLogUser() {
        return logUser;
    }

    public void setLogUser(String logUser) {
        this.logUser = logUser;
    }

    public String getOperationDesc() {
        return operationDesc;
    }

    public void setOperationDesc(String operationDesc) {
        this.operationDesc = operationDesc;
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
        RRepositoryLog other = (RRepositoryLog) that;
        return (this.getIdRepositoryLog() == null ? other.getIdRepositoryLog() == null : this.getIdRepositoryLog().equals(other.getIdRepositoryLog()))
            && (this.getRepVersion() == null ? other.getRepVersion() == null : this.getRepVersion().equals(other.getRepVersion()))
            && (this.getLogDate() == null ? other.getLogDate() == null : this.getLogDate().equals(other.getLogDate()))
            && (this.getLogUser() == null ? other.getLogUser() == null : this.getLogUser().equals(other.getLogUser()))
            && (this.getOperationDesc() == null ? other.getOperationDesc() == null : this.getOperationDesc().equals(other.getOperationDesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdRepositoryLog() == null) ? 0 : getIdRepositoryLog().hashCode());
        result = prime * result + ((getRepVersion() == null) ? 0 : getRepVersion().hashCode());
        result = prime * result + ((getLogDate() == null) ? 0 : getLogDate().hashCode());
        result = prime * result + ((getLogUser() == null) ? 0 : getLogUser().hashCode());
        result = prime * result + ((getOperationDesc() == null) ? 0 : getOperationDesc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idRepositoryLog=").append(idRepositoryLog);
        sb.append(", repVersion=").append(repVersion);
        sb.append(", logDate=").append(logDate);
        sb.append(", logUser=").append(logUser);
        sb.append(", operationDesc=").append(operationDesc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}