package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_dependency
 * @author 
 */
public class RDependency implements Serializable {
    private Long idDependency;

    private Integer idTransformation;

    private Integer idDatabase;

    private String tableName;

    private String fieldName;

    private static final long serialVersionUID = 1L;

    public Long getIdDependency() {
        return idDependency;
    }

    public void setIdDependency(Long idDependency) {
        this.idDependency = idDependency;
    }

    public Integer getIdTransformation() {
        return idTransformation;
    }

    public void setIdTransformation(Integer idTransformation) {
        this.idTransformation = idTransformation;
    }

    public Integer getIdDatabase() {
        return idDatabase;
    }

    public void setIdDatabase(Integer idDatabase) {
        this.idDatabase = idDatabase;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
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
        RDependency other = (RDependency) that;
        return (this.getIdDependency() == null ? other.getIdDependency() == null : this.getIdDependency().equals(other.getIdDependency()))
            && (this.getIdTransformation() == null ? other.getIdTransformation() == null : this.getIdTransformation().equals(other.getIdTransformation()))
            && (this.getIdDatabase() == null ? other.getIdDatabase() == null : this.getIdDatabase().equals(other.getIdDatabase()))
            && (this.getTableName() == null ? other.getTableName() == null : this.getTableName().equals(other.getTableName()))
            && (this.getFieldName() == null ? other.getFieldName() == null : this.getFieldName().equals(other.getFieldName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdDependency() == null) ? 0 : getIdDependency().hashCode());
        result = prime * result + ((getIdTransformation() == null) ? 0 : getIdTransformation().hashCode());
        result = prime * result + ((getIdDatabase() == null) ? 0 : getIdDatabase().hashCode());
        result = prime * result + ((getTableName() == null) ? 0 : getTableName().hashCode());
        result = prime * result + ((getFieldName() == null) ? 0 : getFieldName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idDependency=").append(idDependency);
        sb.append(", idTransformation=").append(idTransformation);
        sb.append(", idDatabase=").append(idDatabase);
        sb.append(", tableName=").append(tableName);
        sb.append(", fieldName=").append(fieldName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}