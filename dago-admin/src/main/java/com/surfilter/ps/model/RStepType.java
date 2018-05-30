package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_step_type
 * @author 
 */
public class RStepType implements Serializable {
    private Long idStepType;

    private String code;

    private String description;

    private String helptext;

    private static final long serialVersionUID = 1L;

    public Long getIdStepType() {
        return idStepType;
    }

    public void setIdStepType(Long idStepType) {
        this.idStepType = idStepType;
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

    public String getHelptext() {
        return helptext;
    }

    public void setHelptext(String helptext) {
        this.helptext = helptext;
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
        RStepType other = (RStepType) that;
        return (this.getIdStepType() == null ? other.getIdStepType() == null : this.getIdStepType().equals(other.getIdStepType()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getHelptext() == null ? other.getHelptext() == null : this.getHelptext().equals(other.getHelptext()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdStepType() == null) ? 0 : getIdStepType().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getHelptext() == null) ? 0 : getHelptext().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idStepType=").append(idStepType);
        sb.append(", code=").append(code);
        sb.append(", description=").append(description);
        sb.append(", helptext=").append(helptext);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}