package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_partition_schema
 * @author 
 */
public class RPartitionSchema implements Serializable {
    private Long idPartitionSchema;

    private String name;

    private Boolean dynamicDefinition;

    private String partitionsPerSlave;

    private static final long serialVersionUID = 1L;

    public Long getIdPartitionSchema() {
        return idPartitionSchema;
    }

    public void setIdPartitionSchema(Long idPartitionSchema) {
        this.idPartitionSchema = idPartitionSchema;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDynamicDefinition() {
        return dynamicDefinition;
    }

    public void setDynamicDefinition(Boolean dynamicDefinition) {
        this.dynamicDefinition = dynamicDefinition;
    }

    public String getPartitionsPerSlave() {
        return partitionsPerSlave;
    }

    public void setPartitionsPerSlave(String partitionsPerSlave) {
        this.partitionsPerSlave = partitionsPerSlave;
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
        RPartitionSchema other = (RPartitionSchema) that;
        return (this.getIdPartitionSchema() == null ? other.getIdPartitionSchema() == null : this.getIdPartitionSchema().equals(other.getIdPartitionSchema()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDynamicDefinition() == null ? other.getDynamicDefinition() == null : this.getDynamicDefinition().equals(other.getDynamicDefinition()))
            && (this.getPartitionsPerSlave() == null ? other.getPartitionsPerSlave() == null : this.getPartitionsPerSlave().equals(other.getPartitionsPerSlave()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdPartitionSchema() == null) ? 0 : getIdPartitionSchema().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDynamicDefinition() == null) ? 0 : getDynamicDefinition().hashCode());
        result = prime * result + ((getPartitionsPerSlave() == null) ? 0 : getPartitionsPerSlave().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idPartitionSchema=").append(idPartitionSchema);
        sb.append(", name=").append(name);
        sb.append(", dynamicDefinition=").append(dynamicDefinition);
        sb.append(", partitionsPerSlave=").append(partitionsPerSlave);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}