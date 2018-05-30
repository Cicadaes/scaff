package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_jobentry_copy
 * @author 
 */
public class RJobentryCopy implements Serializable {
    private Long idJobentryCopy;

    private Integer idJobentry;

    private Integer idJob;

    private Integer idJobentryType;

    private Integer nr;

    private Integer guiLocationX;

    private Integer guiLocationY;

    private Boolean guiDraw;

    private Boolean parallel;

    private static final long serialVersionUID = 1L;

    public Long getIdJobentryCopy() {
        return idJobentryCopy;
    }

    public void setIdJobentryCopy(Long idJobentryCopy) {
        this.idJobentryCopy = idJobentryCopy;
    }

    public Integer getIdJobentry() {
        return idJobentry;
    }

    public void setIdJobentry(Integer idJobentry) {
        this.idJobentry = idJobentry;
    }

    public Integer getIdJob() {
        return idJob;
    }

    public void setIdJob(Integer idJob) {
        this.idJob = idJob;
    }

    public Integer getIdJobentryType() {
        return idJobentryType;
    }

    public void setIdJobentryType(Integer idJobentryType) {
        this.idJobentryType = idJobentryType;
    }

    public Integer getNr() {
        return nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
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

    public Boolean getParallel() {
        return parallel;
    }

    public void setParallel(Boolean parallel) {
        this.parallel = parallel;
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
        RJobentryCopy other = (RJobentryCopy) that;
        return (this.getIdJobentryCopy() == null ? other.getIdJobentryCopy() == null : this.getIdJobentryCopy().equals(other.getIdJobentryCopy()))
            && (this.getIdJobentry() == null ? other.getIdJobentry() == null : this.getIdJobentry().equals(other.getIdJobentry()))
            && (this.getIdJob() == null ? other.getIdJob() == null : this.getIdJob().equals(other.getIdJob()))
            && (this.getIdJobentryType() == null ? other.getIdJobentryType() == null : this.getIdJobentryType().equals(other.getIdJobentryType()))
            && (this.getNr() == null ? other.getNr() == null : this.getNr().equals(other.getNr()))
            && (this.getGuiLocationX() == null ? other.getGuiLocationX() == null : this.getGuiLocationX().equals(other.getGuiLocationX()))
            && (this.getGuiLocationY() == null ? other.getGuiLocationY() == null : this.getGuiLocationY().equals(other.getGuiLocationY()))
            && (this.getGuiDraw() == null ? other.getGuiDraw() == null : this.getGuiDraw().equals(other.getGuiDraw()))
            && (this.getParallel() == null ? other.getParallel() == null : this.getParallel().equals(other.getParallel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdJobentryCopy() == null) ? 0 : getIdJobentryCopy().hashCode());
        result = prime * result + ((getIdJobentry() == null) ? 0 : getIdJobentry().hashCode());
        result = prime * result + ((getIdJob() == null) ? 0 : getIdJob().hashCode());
        result = prime * result + ((getIdJobentryType() == null) ? 0 : getIdJobentryType().hashCode());
        result = prime * result + ((getNr() == null) ? 0 : getNr().hashCode());
        result = prime * result + ((getGuiLocationX() == null) ? 0 : getGuiLocationX().hashCode());
        result = prime * result + ((getGuiLocationY() == null) ? 0 : getGuiLocationY().hashCode());
        result = prime * result + ((getGuiDraw() == null) ? 0 : getGuiDraw().hashCode());
        result = prime * result + ((getParallel() == null) ? 0 : getParallel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idJobentryCopy=").append(idJobentryCopy);
        sb.append(", idJobentry=").append(idJobentry);
        sb.append(", idJob=").append(idJob);
        sb.append(", idJobentryType=").append(idJobentryType);
        sb.append(", nr=").append(nr);
        sb.append(", guiLocationX=").append(guiLocationX);
        sb.append(", guiLocationY=").append(guiLocationY);
        sb.append(", guiDraw=").append(guiDraw);
        sb.append(", parallel=").append(parallel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}