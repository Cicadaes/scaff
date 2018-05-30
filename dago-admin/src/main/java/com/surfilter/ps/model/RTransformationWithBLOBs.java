package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_transformation
 * @author 
 */
public class RTransformationWithBLOBs extends RTransformation implements Serializable {
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
        RTransformationWithBLOBs other = (RTransformationWithBLOBs) that;
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
            && (this.getSizeRowset() == null ? other.getSizeRowset() == null : this.getSizeRowset().equals(other.getSizeRowset()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getExtendedDescription() == null ? other.getExtendedDescription() == null : this.getExtendedDescription().equals(other.getExtendedDescription()));
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