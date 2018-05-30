package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_loglevel
 * @author 
 */
public class RLoglevel implements Serializable {
    private Long idLoglevel;

    private String code;

    private String description;

    private static final long serialVersionUID = 1L;

    public Long getIdLoglevel() {
        return idLoglevel;
    }

    public void setIdLoglevel(Long idLoglevel) {
        this.idLoglevel = idLoglevel;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        RLoglevel other = (RLoglevel) that;
        return (this.getIdLoglevel() == null ? other.getIdLoglevel() == null : this.getIdLoglevel().equals(other.getIdLoglevel()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdLoglevel() == null) ? 0 : getIdLoglevel().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idLoglevel=").append(idLoglevel);
        sb.append(", code=").append(code);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}