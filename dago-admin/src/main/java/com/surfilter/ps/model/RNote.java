package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_note
 * @author 
 */
public class RNote implements Serializable {
    private Long idNote;

    private Integer guiLocationX;

    private Integer guiLocationY;

    private Integer guiLocationWidth;

    private Integer guiLocationHeight;

    private Integer fontSize;

    private Boolean fontBold;

    private Boolean fontItalic;

    private Integer fontColorRed;

    private Integer fontColorGreen;

    private Integer fontColorBlue;

    private Integer fontBackGroundColorRed;

    private Integer fontBackGroundColorGreen;

    private Integer fontBackGroundColorBlue;

    private Integer fontBorderColorRed;

    private Integer fontBorderColorGreen;

    private Integer fontBorderColorBlue;

    private Boolean drawShadow;

    private static final long serialVersionUID = 1L;

    public Long getIdNote() {
        return idNote;
    }

    public void setIdNote(Long idNote) {
        this.idNote = idNote;
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

    public Integer getGuiLocationWidth() {
        return guiLocationWidth;
    }

    public void setGuiLocationWidth(Integer guiLocationWidth) {
        this.guiLocationWidth = guiLocationWidth;
    }

    public Integer getGuiLocationHeight() {
        return guiLocationHeight;
    }

    public void setGuiLocationHeight(Integer guiLocationHeight) {
        this.guiLocationHeight = guiLocationHeight;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    public Boolean getFontBold() {
        return fontBold;
    }

    public void setFontBold(Boolean fontBold) {
        this.fontBold = fontBold;
    }

    public Boolean getFontItalic() {
        return fontItalic;
    }

    public void setFontItalic(Boolean fontItalic) {
        this.fontItalic = fontItalic;
    }

    public Integer getFontColorRed() {
        return fontColorRed;
    }

    public void setFontColorRed(Integer fontColorRed) {
        this.fontColorRed = fontColorRed;
    }

    public Integer getFontColorGreen() {
        return fontColorGreen;
    }

    public void setFontColorGreen(Integer fontColorGreen) {
        this.fontColorGreen = fontColorGreen;
    }

    public Integer getFontColorBlue() {
        return fontColorBlue;
    }

    public void setFontColorBlue(Integer fontColorBlue) {
        this.fontColorBlue = fontColorBlue;
    }

    public Integer getFontBackGroundColorRed() {
        return fontBackGroundColorRed;
    }

    public void setFontBackGroundColorRed(Integer fontBackGroundColorRed) {
        this.fontBackGroundColorRed = fontBackGroundColorRed;
    }

    public Integer getFontBackGroundColorGreen() {
        return fontBackGroundColorGreen;
    }

    public void setFontBackGroundColorGreen(Integer fontBackGroundColorGreen) {
        this.fontBackGroundColorGreen = fontBackGroundColorGreen;
    }

    public Integer getFontBackGroundColorBlue() {
        return fontBackGroundColorBlue;
    }

    public void setFontBackGroundColorBlue(Integer fontBackGroundColorBlue) {
        this.fontBackGroundColorBlue = fontBackGroundColorBlue;
    }

    public Integer getFontBorderColorRed() {
        return fontBorderColorRed;
    }

    public void setFontBorderColorRed(Integer fontBorderColorRed) {
        this.fontBorderColorRed = fontBorderColorRed;
    }

    public Integer getFontBorderColorGreen() {
        return fontBorderColorGreen;
    }

    public void setFontBorderColorGreen(Integer fontBorderColorGreen) {
        this.fontBorderColorGreen = fontBorderColorGreen;
    }

    public Integer getFontBorderColorBlue() {
        return fontBorderColorBlue;
    }

    public void setFontBorderColorBlue(Integer fontBorderColorBlue) {
        this.fontBorderColorBlue = fontBorderColorBlue;
    }

    public Boolean getDrawShadow() {
        return drawShadow;
    }

    public void setDrawShadow(Boolean drawShadow) {
        this.drawShadow = drawShadow;
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
        RNote other = (RNote) that;
        return (this.getIdNote() == null ? other.getIdNote() == null : this.getIdNote().equals(other.getIdNote()))
            && (this.getGuiLocationX() == null ? other.getGuiLocationX() == null : this.getGuiLocationX().equals(other.getGuiLocationX()))
            && (this.getGuiLocationY() == null ? other.getGuiLocationY() == null : this.getGuiLocationY().equals(other.getGuiLocationY()))
            && (this.getGuiLocationWidth() == null ? other.getGuiLocationWidth() == null : this.getGuiLocationWidth().equals(other.getGuiLocationWidth()))
            && (this.getGuiLocationHeight() == null ? other.getGuiLocationHeight() == null : this.getGuiLocationHeight().equals(other.getGuiLocationHeight()))
            && (this.getFontSize() == null ? other.getFontSize() == null : this.getFontSize().equals(other.getFontSize()))
            && (this.getFontBold() == null ? other.getFontBold() == null : this.getFontBold().equals(other.getFontBold()))
            && (this.getFontItalic() == null ? other.getFontItalic() == null : this.getFontItalic().equals(other.getFontItalic()))
            && (this.getFontColorRed() == null ? other.getFontColorRed() == null : this.getFontColorRed().equals(other.getFontColorRed()))
            && (this.getFontColorGreen() == null ? other.getFontColorGreen() == null : this.getFontColorGreen().equals(other.getFontColorGreen()))
            && (this.getFontColorBlue() == null ? other.getFontColorBlue() == null : this.getFontColorBlue().equals(other.getFontColorBlue()))
            && (this.getFontBackGroundColorRed() == null ? other.getFontBackGroundColorRed() == null : this.getFontBackGroundColorRed().equals(other.getFontBackGroundColorRed()))
            && (this.getFontBackGroundColorGreen() == null ? other.getFontBackGroundColorGreen() == null : this.getFontBackGroundColorGreen().equals(other.getFontBackGroundColorGreen()))
            && (this.getFontBackGroundColorBlue() == null ? other.getFontBackGroundColorBlue() == null : this.getFontBackGroundColorBlue().equals(other.getFontBackGroundColorBlue()))
            && (this.getFontBorderColorRed() == null ? other.getFontBorderColorRed() == null : this.getFontBorderColorRed().equals(other.getFontBorderColorRed()))
            && (this.getFontBorderColorGreen() == null ? other.getFontBorderColorGreen() == null : this.getFontBorderColorGreen().equals(other.getFontBorderColorGreen()))
            && (this.getFontBorderColorBlue() == null ? other.getFontBorderColorBlue() == null : this.getFontBorderColorBlue().equals(other.getFontBorderColorBlue()))
            && (this.getDrawShadow() == null ? other.getDrawShadow() == null : this.getDrawShadow().equals(other.getDrawShadow()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdNote() == null) ? 0 : getIdNote().hashCode());
        result = prime * result + ((getGuiLocationX() == null) ? 0 : getGuiLocationX().hashCode());
        result = prime * result + ((getGuiLocationY() == null) ? 0 : getGuiLocationY().hashCode());
        result = prime * result + ((getGuiLocationWidth() == null) ? 0 : getGuiLocationWidth().hashCode());
        result = prime * result + ((getGuiLocationHeight() == null) ? 0 : getGuiLocationHeight().hashCode());
        result = prime * result + ((getFontSize() == null) ? 0 : getFontSize().hashCode());
        result = prime * result + ((getFontBold() == null) ? 0 : getFontBold().hashCode());
        result = prime * result + ((getFontItalic() == null) ? 0 : getFontItalic().hashCode());
        result = prime * result + ((getFontColorRed() == null) ? 0 : getFontColorRed().hashCode());
        result = prime * result + ((getFontColorGreen() == null) ? 0 : getFontColorGreen().hashCode());
        result = prime * result + ((getFontColorBlue() == null) ? 0 : getFontColorBlue().hashCode());
        result = prime * result + ((getFontBackGroundColorRed() == null) ? 0 : getFontBackGroundColorRed().hashCode());
        result = prime * result + ((getFontBackGroundColorGreen() == null) ? 0 : getFontBackGroundColorGreen().hashCode());
        result = prime * result + ((getFontBackGroundColorBlue() == null) ? 0 : getFontBackGroundColorBlue().hashCode());
        result = prime * result + ((getFontBorderColorRed() == null) ? 0 : getFontBorderColorRed().hashCode());
        result = prime * result + ((getFontBorderColorGreen() == null) ? 0 : getFontBorderColorGreen().hashCode());
        result = prime * result + ((getFontBorderColorBlue() == null) ? 0 : getFontBorderColorBlue().hashCode());
        result = prime * result + ((getDrawShadow() == null) ? 0 : getDrawShadow().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idNote=").append(idNote);
        sb.append(", guiLocationX=").append(guiLocationX);
        sb.append(", guiLocationY=").append(guiLocationY);
        sb.append(", guiLocationWidth=").append(guiLocationWidth);
        sb.append(", guiLocationHeight=").append(guiLocationHeight);
        sb.append(", fontSize=").append(fontSize);
        sb.append(", fontBold=").append(fontBold);
        sb.append(", fontItalic=").append(fontItalic);
        sb.append(", fontColorRed=").append(fontColorRed);
        sb.append(", fontColorGreen=").append(fontColorGreen);
        sb.append(", fontColorBlue=").append(fontColorBlue);
        sb.append(", fontBackGroundColorRed=").append(fontBackGroundColorRed);
        sb.append(", fontBackGroundColorGreen=").append(fontBackGroundColorGreen);
        sb.append(", fontBackGroundColorBlue=").append(fontBackGroundColorBlue);
        sb.append(", fontBorderColorRed=").append(fontBorderColorRed);
        sb.append(", fontBorderColorGreen=").append(fontBorderColorGreen);
        sb.append(", fontBorderColorBlue=").append(fontBorderColorBlue);
        sb.append(", drawShadow=").append(drawShadow);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}