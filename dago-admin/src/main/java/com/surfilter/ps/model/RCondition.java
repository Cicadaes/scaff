package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_condition
 * @author 
 */
public class RCondition implements Serializable {
    private Long idCondition;

    private Integer idConditionParent;

    private Boolean negated;

    private String operator;

    private String leftName;

    private String conditionFunction;

    private String rightName;

    private Integer idValueRight;

    private static final long serialVersionUID = 1L;

    public Long getIdCondition() {
        return idCondition;
    }

    public void setIdCondition(Long idCondition) {
        this.idCondition = idCondition;
    }

    public Integer getIdConditionParent() {
        return idConditionParent;
    }

    public void setIdConditionParent(Integer idConditionParent) {
        this.idConditionParent = idConditionParent;
    }

    public Boolean getNegated() {
        return negated;
    }

    public void setNegated(Boolean negated) {
        this.negated = negated;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getLeftName() {
        return leftName;
    }

    public void setLeftName(String leftName) {
        this.leftName = leftName;
    }

    public String getConditionFunction() {
        return conditionFunction;
    }

    public void setConditionFunction(String conditionFunction) {
        this.conditionFunction = conditionFunction;
    }

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName;
    }

    public Integer getIdValueRight() {
        return idValueRight;
    }

    public void setIdValueRight(Integer idValueRight) {
        this.idValueRight = idValueRight;
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
        RCondition other = (RCondition) that;
        return (this.getIdCondition() == null ? other.getIdCondition() == null : this.getIdCondition().equals(other.getIdCondition()))
            && (this.getIdConditionParent() == null ? other.getIdConditionParent() == null : this.getIdConditionParent().equals(other.getIdConditionParent()))
            && (this.getNegated() == null ? other.getNegated() == null : this.getNegated().equals(other.getNegated()))
            && (this.getOperator() == null ? other.getOperator() == null : this.getOperator().equals(other.getOperator()))
            && (this.getLeftName() == null ? other.getLeftName() == null : this.getLeftName().equals(other.getLeftName()))
            && (this.getConditionFunction() == null ? other.getConditionFunction() == null : this.getConditionFunction().equals(other.getConditionFunction()))
            && (this.getRightName() == null ? other.getRightName() == null : this.getRightName().equals(other.getRightName()))
            && (this.getIdValueRight() == null ? other.getIdValueRight() == null : this.getIdValueRight().equals(other.getIdValueRight()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdCondition() == null) ? 0 : getIdCondition().hashCode());
        result = prime * result + ((getIdConditionParent() == null) ? 0 : getIdConditionParent().hashCode());
        result = prime * result + ((getNegated() == null) ? 0 : getNegated().hashCode());
        result = prime * result + ((getOperator() == null) ? 0 : getOperator().hashCode());
        result = prime * result + ((getLeftName() == null) ? 0 : getLeftName().hashCode());
        result = prime * result + ((getConditionFunction() == null) ? 0 : getConditionFunction().hashCode());
        result = prime * result + ((getRightName() == null) ? 0 : getRightName().hashCode());
        result = prime * result + ((getIdValueRight() == null) ? 0 : getIdValueRight().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idCondition=").append(idCondition);
        sb.append(", idConditionParent=").append(idConditionParent);
        sb.append(", negated=").append(negated);
        sb.append(", operator=").append(operator);
        sb.append(", leftName=").append(leftName);
        sb.append(", conditionFunction=").append(conditionFunction);
        sb.append(", rightName=").append(rightName);
        sb.append(", idValueRight=").append(idValueRight);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}