package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_step
 * @author 
 */
public class RStep implements Serializable {
    private Long idStep;

    private Integer idTransformation;

    private String name;

    private Integer idStepType;

    private Boolean distribute;

    private Integer copies;

    private Integer guiLocationX;

    private Integer guiLocationY;

    private Boolean guiDraw;

    private String copiesString;

    private String description;

    private static final long serialVersionUID = 1L;

    public Long getIdStep() {
        return idStep;
    }

    public void setIdStep(Long idStep) {
        this.idStep = idStep;
    }

    public Integer getIdTransformation() {
        return idTransformation;
    }

    public void setIdTransformation(Integer idTransformation) {
        this.idTransformation = idTransformation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdStepType() {
        return idStepType;
    }

    public void setIdStepType(Integer idStepType) {
        this.idStepType = idStepType;
    }

    public Boolean getDistribute() {
        return distribute;
    }

    public void setDistribute(Boolean distribute) {
        this.distribute = distribute;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public Integer getGuiLocationX() {
        return guiLocationX;
    }

    public void setGuiLocationX(Integer guiLocationX) {
        this.guiLocationX = guiLocationX;
    }

    public Integer getGuiLocationY() {
        return guiLocationY;
    }

    public void setGuiLocationY(Integer guiLocationY) {
        this.guiLocationY = guiLocationY;
    }

    public Boolean getGuiDraw() {
        return guiDraw;
    }

    public void setGuiDraw(Boolean guiDraw) {
        this.guiDraw = guiDraw;
    }

    public String getCopiesString() {
        return copiesString;
    }

    public void setCopiesString(String copiesString) {
        this.copiesString = copiesString;
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
        RStep other = (RStep) that;
        return (this.getIdStep() == null ? other.getIdStep() == null : this.getIdStep().equals(other.getIdStep()))
            && (this.getIdTransformation() == null ? other.getIdTransformation() == null : this.getIdTransformation().equals(other.getIdTransformation()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getIdStepType() == null ? other.getIdStepType() == null : this.getIdStepType().equals(other.getIdStepType()))
            && (this.getDistribute() == null ? other.getDistribute() == null : this.getDistribute().equals(other.getDistribute()))
            && (this.getCopies() == null ? other.getCopies() == null : this.getCopies().equals(other.getCopies()))
            && (this.getGuiLocationX() == null ? other.getGuiLocationX() == null : this.getGuiLocationX().equals(other.getGuiLocationX()))
            && (this.getGuiLocationY() == null ? other.getGuiLocationY() == null : this.getGuiLocationY().equals(other.getGuiLocationY()))
            && (this.getGuiDraw() == null ? other.getGuiDraw() == null : this.getGuiDraw().equals(other.getGuiDraw()))
            && (this.getCopiesString() == null ? other.getCopiesString() == null : this.getCopiesString().equals(other.getCopiesString()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdStep() == null) ? 0 : getIdStep().hashCode());
        result = prime * result + ((getIdTransformation() == null) ? 0 : getIdTransformation().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getIdStepType() == null) ? 0 : getIdStepType().hashCode());
        result = prime * result + ((getDistribute() == null) ? 0 : getDistribute().hashCode());
        result = prime * result + ((getCopies() == null) ? 0 : getCopies().hashCode());
        result = prime * result + ((getGuiLocationX() == null) ? 0 : getGuiLocationX().hashCode());
        result = prime * result + ((getGuiLocationY() == null) ? 0 : getGuiLocationY().hashCode());
        result = prime * result + ((getGuiDraw() == null) ? 0 : getGuiDraw().hashCode());
        result = prime * result + ((getCopiesString() == null) ? 0 : getCopiesString().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idStep=").append(idStep);
        sb.append(", idTransformation=").append(idTransformation);
        sb.append(", name=").append(name);
        sb.append(", idStepType=").append(idStepType);
        sb.append(", distribute=").append(distribute);
        sb.append(", copies=").append(copies);
        sb.append(", guiLocationX=").append(guiLocationX);
        sb.append(", guiLocationY=").append(guiLocationY);
        sb.append(", guiDraw=").append(guiDraw);
        sb.append(", copiesString=").append(copiesString);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}