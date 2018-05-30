package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_partition
 * @author 
 */
public class RPartition implements Serializable {
    private Long idPartition;

    private Integer idPartitionSchema;

    private String partitionId;

    private static final long serialVersionUID = 1L;

    public Long getIdPartition() {
        return idPartition;
    }

    public void setIdPartition(Long idPartition) {
        this.idPartition = idPartition;
    }

    public Integer getIdPartitionSchema() {
        return idPartitionSchema;
    }

    public void setIdPartitionSchema(Integer idPartitionSchema) {
        this.idPartitionSchema = idPartitionSchema;
    }

    public String getPartitionId() {
        return partitionId;
    }

    public void setPartitionId(String partitionId) {
        this.partitionId = partitionId;
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
        RPartition other = (RPartition) that;
        return (this.getIdPartition() == null ? other.getIdPartition() == null : this.getIdPartition().equals(other.getIdPartition()))
            && (this.getIdPartitionSchema() == null ? other.getIdPartitionSchema() == null : this.getIdPartitionSchema().equals(other.getIdPartitionSchema()))
            && (this.getPartitionId() == null ? other.getPartitionId() == null : this.getPartitionId().equals(other.getPartitionId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdPartition() == null) ? 0 : getIdPartition().hashCode());
        result = prime * result + ((getIdPartitionSchema() == null) ? 0 : getIdPartitionSchema().hashCode());
        result = prime * result + ((getPartitionId() == null) ? 0 : getPartitionId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idPartition=").append(idPartition);
        sb.append(", idPartitionSchema=").append(idPartitionSchema);
        sb.append(", partitionId=").append(partitionId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}