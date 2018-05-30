package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_trans_partition_schema
 * @author 
 */
public class RTransPartitionSchema implements Serializable {
    private Long idTransPartitionSchema;

    private Integer idTransformation;

    private Integer idPartitionSchema;

    private static final long serialVersionUID = 1L;

    public Long getIdTransPartitionSchema() {
        return idTransPartitionSchema;
    }

    public void setIdTransPartitionSchema(Long idTransPartitionSchema) {
        this.idTransPartitionSchema = idTransPartitionSchema;
    }

    public Integer getIdTransformation() {
        return idTransformation;
    }

    public void setIdTransformation(Integer idTransformation) {
        this.idTransformation = idTransformation;
    }

    public Integer getIdPartitionSchema() {
        return idPartitionSchema;
    }

    public void setIdPartitionSchema(Integer idPartitionSchema) {
        this.idPartitionSchema = idPartitionSchema;
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
        RTransPartitionSchema other = (RTransPartitionSchema) that;
        return (this.getIdTransPartitionSchema() == null ? other.getIdTransPartitionSchema() == null : this.getIdTransPartitionSchema().equals(other.getIdTransPartitionSchema()))
            && (this.getIdTransformation() == null ? other.getIdTransformation() == null : this.getIdTransformation().equals(other.getIdTransformation()))
            && (this.getIdPartitionSchema() == null ? other.getIdPartitionSchema() == null : this.getIdPartitionSchema().equals(other.getIdPartitionSchema()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdTransPartitionSchema() == null) ? 0 : getIdTransPartitionSchema().hashCode());
        result = prime * result + ((getIdTransformation() == null) ? 0 : getIdTransformation().hashCode());
        result = prime * result + ((getIdPartitionSchema() == null) ? 0 : getIdPartitionSchema().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idTransPartitionSchema=").append(idTransPartitionSchema);
        sb.append(", idTransformation=").append(idTransformation);
        sb.append(", idPartitionSchema=").append(idPartitionSchema);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}