package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_log
 * @author 
 */
public class RLog implements Serializable {
    private Long idLog;

    private String name;

    private Integer idLoglevel;

    private String logtype;

    private String filename;

    private String fileextention;

    private Boolean addDate;

    private Boolean addTime;

    private Integer idDatabaseLog;

    private String tableNameLog;

    private static final long serialVersionUID = 1L;

    public Long getIdLog() {
        return idLog;
    }

    public void setIdLog(Long idLog) {
        this.idLog = idLog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdLoglevel() {
        return idLoglevel;
    }

    public void setIdLoglevel(Integer idLoglevel) {
        this.idLoglevel = idLoglevel;
    }

    public String getLogtype() {
        return logtype;
    }

    public void setLogtype(String logtype) {
        this.logtype = logtype;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileextention() {
        return fileextention;
    }

    public void setFileextention(String fileextention) {
        this.fileextention = fileextention;
    }

    public Boolean getAddDate() {
        return addDate;
    }

    public void setAddDate(Boolean addDate) {
        this.addDate = addDate;
    }

    public Boolean getAddTime() {
        return addTime;
    }

    public void setAddTime(Boolean addTime) {
        this.addTime = addTime;
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
        RLog other = (RLog) that;
        return (this.getIdLog() == null ? other.getIdLog() == null : this.getIdLog().equals(other.getIdLog()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getIdLoglevel() == null ? other.getIdLoglevel() == null : this.getIdLoglevel().equals(other.getIdLoglevel()))
            && (this.getLogtype() == null ? other.getLogtype() == null : this.getLogtype().equals(other.getLogtype()))
            && (this.getFilename() == null ? other.getFilename() == null : this.getFilename().equals(other.getFilename()))
            && (this.getFileextention() == null ? other.getFileextention() == null : this.getFileextention().equals(other.getFileextention()))
            && (this.getAddDate() == null ? other.getAddDate() == null : this.getAddDate().equals(other.getAddDate()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getIdDatabaseLog() == null ? other.getIdDatabaseLog() == null : this.getIdDatabaseLog().equals(other.getIdDatabaseLog()))
            && (this.getTableNameLog() == null ? other.getTableNameLog() == null : this.getTableNameLog().equals(other.getTableNameLog()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdLog() == null) ? 0 : getIdLog().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getIdLoglevel() == null) ? 0 : getIdLoglevel().hashCode());
        result = prime * result + ((getLogtype() == null) ? 0 : getLogtype().hashCode());
        result = prime * result + ((getFilename() == null) ? 0 : getFilename().hashCode());
        result = prime * result + ((getFileextention() == null) ? 0 : getFileextention().hashCode());
        result = prime * result + ((getAddDate() == null) ? 0 : getAddDate().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getIdDatabaseLog() == null) ? 0 : getIdDatabaseLog().hashCode());
        result = prime * result + ((getTableNameLog() == null) ? 0 : getTableNameLog().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idLog=").append(idLog);
        sb.append(", name=").append(name);
        sb.append(", idLoglevel=").append(idLoglevel);
        sb.append(", logtype=").append(logtype);
        sb.append(", filename=").append(filename);
        sb.append(", fileextention=").append(fileextention);
        sb.append(", addDate=").append(addDate);
        sb.append(", addTime=").append(addTime);
        sb.append(", idDatabaseLog=").append(idDatabaseLog);
        sb.append(", tableNameLog=").append(tableNameLog);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}