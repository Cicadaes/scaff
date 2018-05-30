package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_note
 * @author 
 */
public class RNoteWithBLOBs extends RNote implements Serializable {
    private String valueStr;

    private String fontName;

    private static final long serialVersionUID = 1L;

    public String getValueStr() {
        return valueStr;
    }

    public void setValueStr(String valueStr) {
        this.valueStr = valueStr;
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
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
        RNoteWithBLOBs other = (RNoteWithBLOBs) that;
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
            && (this.getDrawShadow() == null ? other.getDrawShadow() == null : this.getDrawShadow().equals(other.getDrawShadow()))
            && (this.getValueStr() == null ? other.getValueStr() == null : this.getValueStr().equals(other.getValueStr()))
            && (this.getFontName() == null ? other.getFontName() == null : this.getFontName().equals(other.getFontName()));
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
        result = prime * result + ((getValueStr() == null) ? 0 : getValueStr().hashCode());
        result = prime * result + ((getFontName() == null) ? 0 : getFontName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", valueStr=").append(valueStr);
        sb.append(", fontName=").append(fontName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}