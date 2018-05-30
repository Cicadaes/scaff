package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_database_attribute
 * @author 
 */
public class RDatabaseAttribute implements Serializable {
    private Long idDatabaseAttribute;

    private Integer idDatabase;

    private String code;

    private String valueStr;

    private static final long serialVersionUID = 1L;

    public Long getIdDatabaseAttribute() {
        return idDatabaseAttribute;
    }

    public void setIdDatabaseAttribute(Long idDatabaseAttribute) {
        this.idDatabaseAttribute = idDatabaseAttribute;
    }

    public Integer getIdDatabase() {
        return idDatabase;
    }

    public void setIdDatabase(Integer idDatabase) {
        this.idDatabase = idDatabase;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValueStr() {
        return valueStr;
    }

    public void setValueStr(String valueStr) {
        this.valueStr = valueStr;
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
        RDatabaseAttribute other = (RDatabaseAttribute) that;
        return (this.getIdDatabaseAttribute() == null ? other.getIdDatabaseAttribute() == null : this.getIdDatabaseAttribute().equals(other.getIdDatabaseAttribute()))
            && (this.getIdDatabase() == null ? other.getIdDatabase() == null : this.getIdDatabase().equals(other.getIdDatabase()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getValueStr() == null ? other.getValueStr() == null : this.getValueStr().equals(other.getValueStr()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdDatabaseAttribute() == null) ? 0 : getIdDatabaseAttribute().hashCode());
        result = prime * result + ((getIdDatabase() == null) ? 0 : getIdDatabase().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getValueStr() == null) ? 0 : getValueStr().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idDatabaseAttribute=").append(idDatabaseAttribute);
        sb.append(", idDatabase=").append(idDatabase);
        sb.append(", code=").append(code);
        sb.append(", valueStr=").append(valueStr);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}