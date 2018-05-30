package com.surfilter.ps.model;

import java.io.Serializable;
import java.util.Date;

/**
 * r_transformation
 * @author 
 */
public class RTransformation implements Serializable {
    private Long idTransformation;

    private Integer idDirectory;

    private String name;

    private String transVersion;

    private Integer transStatus;

    private Integer idStepRead;

    private Integer idStepWrite;

    private Integer idStepInput;

    private Integer idStepOutput;

    private Integer idStepUpdate;

    private Integer idDatabaseLog;

    private String tableNameLog;

    private Boolean useBatchid;

    private Boolean useLogfield;

    private Integer idDatabaseMaxdate;

    private String tableNameMaxdate;

    private String fieldNameMaxdate;

    private Double offsetMaxdate;

    private Double diffMaxdate;

    private String createdUser;

    private Date createdDate;

    private String modifiedUser;

    private Date modifiedDate;

    private Integer sizeRowset;

    private static final long serialVersionUID = 1L;

    public Long getIdTransformation() {
        return idTransformation;
    }

    public void setIdTransformation(Long idTransformation) {
        this.idTransformation = idTransformation;
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

    public String getTransVersion() {
        return transVersion;
    }

    public void setTransVersion(String transVersion) {
        this.transVersion = transVersion;
    }

    public Integer getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(Integer transStatus) {
        this.transStatus = transStatus;
    }

    public Integer getIdStepRead() {
        return idStepRead;
    }

    public void setIdStepRead(Integer idStepRead) {
        this.idStepRead = idStepRead;
    }

    public Integer getIdStepWrite() {
        return idStepWrite;
    }

    public void setIdStepWrite(Integer idStepWrite) {
        this.idStepWrite = idStepWrite;
    }

    public Integer getIdStepInput() {
        return idStepInput;
    }

    public void setIdStepInput(Integer idStepInput) {
        this.idStepInput = idStepInput;
    }

    public Integer getIdStepOutput() {
        return idStepOutput;
    }

    public void setIdStepOutput(Integer idStepOutput) {
        this.idStepOutput = idStepOutput;
    }

    public Integer getIdStepUpdate() {
        return idStepUpdate;
    }

    public void setIdStepUpdate(Integer idStepUpdate) {
        this.idStepUpdate = idStepUpdate;
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

    public Boolean getUseBatchid() {
        return useBatchid;
    }

    public void setUseBatchid(Boolean useBatchid) {
        this.useBatchid = useBatchid;
    }

    public Boolean getUseLogfield() {
        return useLogfield;
    }

    public void setUseLogfield(Boolean useLogfield) {
        this.useLogfield = useLogfield;
    }

    public Integer getIdDatabaseMaxdate() {
        return idDatabaseMaxdate;
    }

    public void setIdDatabaseMaxdate(Integer idDatabaseMaxdate) {
        this.idDatabaseMaxdate = idDatabaseMaxdate;
    }

    public String getTableNameMaxdate() {
        return tableNameMaxdate;
    }

    public void setTableNameMaxdate(String tableNameMaxdate) {
        this.tableNameMaxdate = tableNameMaxdate;
    }

    public String getFieldNameMaxdate() {
        return fieldNameMaxdate;
    }

    public void setFieldNameMaxdate(String fieldNameMaxdate) {
        this.fieldNameMaxdate = fieldNameMaxdate;
    }

    public Double getOffsetMaxdate() {
        return offsetMaxdate;
    }

    public void setOffsetMaxdate(Double offsetMaxdate) {
        this.offsetMaxdate = offsetMaxdate;
    }

    public Double getDiffMaxdate() {
        return diffMaxdate;
    }

    public void setDiffMaxdate(Double diffMaxdate) {
        this.diffMaxdate = diffMaxdate;
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

    public Integer getSizeRowset() {
        return sizeRowset;
    }

    public void setSizeRowset(Integer sizeRowset) {
        this.sizeRowset = sizeRowset;
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
        RTransformation other = (RTransformation) that;
        return (this.getIdTransformation() == null ? other.getIdTransformation() == null : this.getIdTransformation().equals(other.getIdTransformation()))
            && (this.getIdDirectory() == null ? other.getIdDirectory() == null : this.getIdDirectory().equals(other.getIdDirectory()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTransVersion() == null ? other.getTransVersion() == null : this.getTransVersion().equals(other.getTransVersion()))
            && (this.getTransStatus() == null ? other.getTransStatus() == null : this.getTransStatus().equals(other.getTransStatus()))
            && (this.getIdStepRead() == null ? other.getIdStepRead() == null : this.getIdStepRead().equals(other.getIdStepRead()))
            && (this.getIdStepWrite() == null ? other.getIdStepWrite() == null : this.getIdStepWrite().equals(other.getIdStepWrite()))
            && (this.getIdStepInput() == null ? other.getIdStepInput() == null : this.getIdStepInput().equals(other.getIdStepInput()))
            && (this.getIdStepOutput() == null ? other.getIdStepOutput() == null : this.getIdStepOutput().equals(other.getIdStepOutput()))
            && (this.getIdStepUpdate() == null ? other.getIdStepUpdate() == null : this.getIdStepUpdate().equals(other.getIdStepUpdate()))
            && (this.getIdDatabaseLog() == null ? other.getIdDatabaseLog() == null : this.getIdDatabaseLog().equals(other.getIdDatabaseLog()))
            && (this.getTableNameLog() == null ? other.getTableNameLog() == null : this.getTableNameLog().equals(other.getTableNameLog()))
            && (this.getUseBatchid() == null ? other.getUseBatchid() == null : this.getUseBatchid().equals(other.getUseBatchid()))
            && (this.getUseLogfield() == null ? other.getUseLogfield() == null : this.getUseLogfield().equals(other.getUseLogfield()))
            && (this.getIdDatabaseMaxdate() == null ? other.getIdDatabaseMaxdate() == null : this.getIdDatabaseMaxdate().equals(other.getIdDatabaseMaxdate()))
            && (this.getTableNameMaxdate() == null ? other.getTableNameMaxdate() == null : this.getTableNameMaxdate().equals(other.getTableNameMaxdate()))
            && (this.getFieldNameMaxdate() == null ? other.getFieldNameMaxdate() == null : this.getFieldNameMaxdate().equals(other.getFieldNameMaxdate()))
            && (this.getOffsetMaxdate() == null ? other.getOffsetMaxdate() == null : this.getOffsetMaxdate().equals(other.getOffsetMaxdate()))
            && (this.getDiffMaxdate() == null ? other.getDiffMaxdate() == null : this.getDiffMaxdate().equals(other.getDiffMaxdate()))
            && (this.getCreatedUser() == null ? other.getCreatedUser() == null : this.getCreatedUser().equals(other.getCreatedUser()))
            && (this.getCreatedDate() == null ? other.getCreatedDate() == null : this.getCreatedDate().equals(other.getCreatedDate()))
            && (this.getModifiedUser() == null ? other.getModifiedUser() == null : this.getModifiedUser().equals(other.getModifiedUser()))
            && (this.getModifiedDate() == null ? other.getModifiedDate() == null : this.getModifiedDate().equals(other.getModifiedDate()))
            && (this.getSizeRowset() == null ? other.getSizeRowset() == null : this.getSizeRowset().equals(other.getSizeRowset()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdTransformation() == null) ? 0 : getIdTransformation().hashCode());
        result = prime * result + ((getIdDirectory() == null) ? 0 : getIdDirectory().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTransVersion() == null) ? 0 : getTransVersion().hashCode());
        result = prime * result + ((getTransStatus() == null) ? 0 : getTransStatus().hashCode());
        result = prime * result + ((getIdStepRead() == null) ? 0 : getIdStepRead().hashCode());
        result = prime * result + ((getIdStepWrite() == null) ? 0 : getIdStepWrite().hashCode());
        result = prime * result + ((getIdStepInput() == null) ? 0 : getIdStepInput().hashCode());
        result = prime * result + ((getIdStepOutput() == null) ? 0 : getIdStepOutput().hashCode());
        result = prime * result + ((getIdStepUpdate() == null) ? 0 : getIdStepUpdate().hashCode());
        result = prime * result + ((getIdDatabaseLog() == null) ? 0 : getIdDatabaseLog().hashCode());
        result = prime * result + ((getTableNameLog() == null) ? 0 : getTableNameLog().hashCode());
        result = prime * result + ((getUseBatchid() == null) ? 0 : getUseBatchid().hashCode());
        result = prime * result + ((getUseLogfield() == null) ? 0 : getUseLogfield().hashCode());
        result = prime * result + ((getIdDatabaseMaxdate() == null) ? 0 : getIdDatabaseMaxdate().hashCode());
        result = prime * result + ((getTableNameMaxdate() == null) ? 0 : getTableNameMaxdate().hashCode());
        result = prime * result + ((getFieldNameMaxdate() == null) ? 0 : getFieldNameMaxdate().hashCode());
        result = prime * result + ((getOffsetMaxdate() == null) ? 0 : getOffsetMaxdate().hashCode());
        result = prime * result + ((getDiffMaxdate() == null) ? 0 : getDiffMaxdate().hashCode());
        result = prime * result + ((getCreatedUser() == null) ? 0 : getCreatedUser().hashCode());
        result = prime * result + ((getCreatedDate() == null) ? 0 : getCreatedDate().hashCode());
        result = prime * result + ((getModifiedUser() == null) ? 0 : getModifiedUser().hashCode());
        result = prime * result + ((getModifiedDate() == null) ? 0 : getModifiedDate().hashCode());
        result = prime * result + ((getSizeRowset() == null) ? 0 : getSizeRowset().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idTransformation=").append(idTransformation);
        sb.append(", idDirectory=").append(idDirectory);
        sb.append(", name=").append(name);
        sb.append(", transVersion=").append(transVersion);
        sb.append(", transStatus=").append(transStatus);
        sb.append(", idStepRead=").append(idStepRead);
        sb.append(", idStepWrite=").append(idStepWrite);
        sb.append(", idStepInput=").append(idStepInput);
        sb.append(", idStepOutput=").append(idStepOutput);
        sb.append(", idStepUpdate=").append(idStepUpdate);
        sb.append(", idDatabaseLog=").append(idDatabaseLog);
        sb.append(", tableNameLog=").append(tableNameLog);
        sb.append(", useBatchid=").append(useBatchid);
        sb.append(", useLogfield=").append(useLogfield);
        sb.append(", idDatabaseMaxdate=").append(idDatabaseMaxdate);
        sb.append(", tableNameMaxdate=").append(tableNameMaxdate);
        sb.append(", fieldNameMaxdate=").append(fieldNameMaxdate);
        sb.append(", offsetMaxdate=").append(offsetMaxdate);
        sb.append(", diffMaxdate=").append(diffMaxdate);
        sb.append(", createdUser=").append(createdUser);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", modifiedUser=").append(modifiedUser);
        sb.append(", modifiedDate=").append(modifiedDate);
        sb.append(", sizeRowset=").append(sizeRowset);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}