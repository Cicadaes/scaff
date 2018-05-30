package com.surfilter.ps.model;

import java.io.Serializable;
import java.util.Date;

/**
 * r_job
 * @author 
 */
public class RJob implements Serializable {
    private Long idJob;

    private Integer idDirectory;

    private String name;

    private String jobVersion;

    private Integer jobStatus;

    private Integer idDatabaseLog;

    private String tableNameLog;

    private String createdUser;

    private Date createdDate;

    private String modifiedUser;

    private Date modifiedDate;

    private Boolean useBatchId;

    private Boolean passBatchId;

    private Boolean useLogfield;

    private String sharedFile;

    private static final long serialVersionUID = 1L;

    public Long getIdJob() {
        return idJob;
    }

    public void setIdJob(Long idJob) {
        this.idJob = idJob;
    }

    public Integer getIdDirectory() {
        return idDirectory;
    }

    public void setIdDirectory(Integer idDirectory) {
        this.idDirectory = idDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobVersion() {
        return jobVersion;
    }

    public void setJobVersion(String jobVersion) {
        this.jobVersion = jobVersion;
    }

    public Integer getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(Integer jobStatus) {
        this.jobStatus = jobStatus;
    }

    public Integer getIdDatabaseLog() {
        return idDatabaseLog;
    }

    public void setIdDatabaseLog(Integer idDatabaseLog) {
        this.idDatabaseLog = idDatabaseLog;
    }

    public String getTableNameLog() {
        return tableNameLog;
    }

    public void setTableNameLog(String tableNameLog) {
        this.tableNameLog = tableNameLog;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Boolean getUseBatchId() {
        return useBatchId;
    }

    public void setUseBatchId(Boolean useBatchId) {
        this.useBatchId = useBatchId;
    }

    public Boolean getPassBatchId() {
        return passBatchId;
    }

    public void setPassBatchId(Boolean passBatchId) {
        this.passBatchId = passBatchId;
    }

    public Boolean getUseLogfield() {
        return useLogfield;
    }

    public void setUseLogfield(Boolean useLogfield) {
        this.useLogfield = useLogfield;
    }

    public String getSharedFile() {
        return sharedFile;
    }

    public void setSharedFile(String sharedFile) {
        this.sharedFile = sharedFile;
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
        RJob other = (RJob) that;
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
            && (this.getSharedFile() == null ? other.getSharedFile() == null : this.getSharedFile().equals(other.getSharedFile()));
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
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idJob=").append(idJob);
        sb.append(", idDirectory=").append(idDirectory);
        sb.append(", name=").append(name);
        sb.append(", jobVersion=").append(jobVersion);
        sb.append(", jobStatus=").append(jobStatus);
        sb.append(", idDatabaseLog=").append(idDatabaseLog);
        sb.append(", tableNameLog=").append(tableNameLog);
        sb.append(", createdUser=").append(createdUser);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", modifiedUser=").append(modifiedUser);
        sb.append(", modifiedDate=").append(modifiedDate);
        sb.append(", useBatchId=").append(useBatchId);
        sb.append(", passBatchId=").append(passBatchId);
        sb.append(", useLogfield=").append(useLogfield);
        sb.append(", sharedFile=").append(sharedFile);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}