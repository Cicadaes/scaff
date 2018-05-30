package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_job
 * @author 
 */
public class RJobWithBLOBs extends RJob implements Serializable {
    private String description;

    private String extendedDescription;

    private static final long serialVersionUID = 1L;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExtendedDescription() {
        return extendedDescription;
    }

    public void setExtendedDescription(String extendedDescription) {
        this.extendedDescription = extendedDescription;
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
        RJobWithBLOBs other = (RJobWithBLOBs) that;
        return (this.getIdJob() == null ? other.getIdJob() == null : this.getIdJob().equals(other.getIdJob()))
            && (this.getIdDirectory() == null ? other.getIdDirectory() == null : this.getIdDirectory().equals(other.getIdDirectory()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getJobVersion() == null ? other.getJobVersion() == null : this.getJobVersion().equals(other.getJobVersion()))
            && (this.getJobStatus() == null ? other.getJobStatus() == null : this.getJobStatus().equals(other.getJobStatus()))
            && (this.getIdDatabaseLog() == null ? other.getIdDatabaseLog() == null : this.getIdDatabaseLog().equals(other.getIdDatabaseLog()))
            && (this.getTableNameLog() == null ? other.getTableNameLog() == null : this.getTableNameLog().equals(other.getTableNameLog()))
            && (this.getCreatedUser() == null ? other.getCreatedUser() == null : this.getCreatedUser().equals(other.getCreatedUser()))
            && (this.getCreatedDate() == null ? other.getCreatedDate() == null : this.getCreatedDate().equals(other.getCreatedDate()))
            && (this.getModifiedUser() == null ? other.getModifiedUser() == null : this.getModifiedUser().equals(other.getModifiedUser()))
            && (this.getModifiedDate() == null ? other.getModifiedDate() == null : this.getModifiedDate().equals(other.getModifiedDate()))
            && (this.getUseBatchId() == null ? other.getUseBatchId() == null : this.getUseBatchId().equals(other.getUseBatchId()))
            && (this.getPassBatchId() == null ? other.getPassBatchId() == null : this.getPassBatchId().equals(other.getPassBatchId()))
            && (this.getUseLogfield() == null ? other.getUseLogfield() == null : this.getUseLogfield().equals(other.getUseLogfield()))
            && (this.getSharedFile() == null ? other.getSharedFile() == null : this.getSharedFile().equals(other.getSharedFile()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getExtendedDescription() == null ? other.getExtendedDescription() == null : this.getExtendedDescription().equals(other.getExtendedDescription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdJob() == null) ? 0 : getIdJob().hashCode());
        result = prime * result + ((getIdDirectory() == null) ? 0 : getIdDirectory().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getJobVersion() == null) ? 0 : getJobVersion().hashCode());
        result = prime * result + ((getJobStatus() == null) ? 0 : getJobStatus().hashCode());
        result = prime * result + ((getIdDatabaseLog() == null) ? 0 : getIdDatabaseLog().hashCode());
        result = prime * result + ((getTableNameLog() == null) ? 0 : getTableNameLog().hashCode());
        result = prime * result + ((getCreatedUser() == null) ? 0 : getCreatedUser().hashCode());
        result = prime * result + ((getCreatedDate() == null) ? 0 : getCreatedDate().hashCode());
        result = prime * result + ((getModifiedUser() == null) ? 0 : getModifiedUser().hashCode());
        result = prime * result + ((getModifiedDate() == null) ? 0 : getModifiedDate().hashCode());
        result = prime * result + ((getUseBatchId() == null) ? 0 : getUseBatchId().hashCode());
        result = prime * result + ((getPassBatchId() == null) ? 0 : getPassBatchId().hashCode());
        result = prime * result + ((getUseLogfield() == null) ? 0 : getUseLogfield().hashCode());
        result = prime * result + ((getSharedFile() == null) ? 0 : getSharedFile().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getExtendedDescription() == null) ? 0 : getExtendedDescription().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", description=").append(description);
        sb.append(", extendedDescription=").append(extendedDescription);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}