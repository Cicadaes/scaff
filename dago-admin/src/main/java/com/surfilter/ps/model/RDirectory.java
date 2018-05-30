package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_directory
 * @author 
 */
public class RDirectory implements Serializable {
    private Long idDirectory;

    private Integer idDirectoryParent;

    private String directoryName;

    private static final long serialVersionUID = 1L;

    public Long getIdDirectory() {
        return idDirectory;
    }

    public void setIdDirectory(Long idDirectory) {
        this.idDirectory = idDirectory;
    }

    public Integer getIdDirectoryParent() {
        return idDirectoryParent;
    }

    public void setIdDirectoryParent(Integer idDirectoryParent) {
        this.idDirectoryParent = idDirectoryParent;
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
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
        RDirectory other = (RDirectory) that;
        return (this.getIdDirectory() == null ? other.getIdDirectory() == null : this.getIdDirectory().equals(other.getIdDirectory()))
            && (this.getIdDirectoryParent() == null ? other.getIdDirectoryParent() == null : this.getIdDirectoryParent().equals(other.getIdDirectoryParent()))
            && (this.getDirectoryName() == null ? other.getDirectoryName() == null : this.getDirectoryName().equals(other.getDirectoryName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdDirectory() == null) ? 0 : getIdDirectory().hashCode());
        result = prime * result + ((getIdDirectoryParent() == null) ? 0 : getIdDirectoryParent().hashCode());
        result = prime * result + ((getDirectoryName() == null) ? 0 : getDirectoryName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idDirectory=").append(idDirectory);
        sb.append(", idDirectoryParent=").append(idDirectoryParent);
        sb.append(", directoryName=").append(directoryName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}