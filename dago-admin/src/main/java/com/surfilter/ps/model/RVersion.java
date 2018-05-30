package com.surfilter.ps.model;

import java.io.Serializable;
import java.util.Date;

/**
 * r_version
 * @author 
 */
public class RVersion implements Serializable {
    private Long idVersion;

    private Integer majorVersion;

    private Integer minorVersion;

    private Date upgradeDate;

    private Boolean isUpgrade;

    private static final long serialVersionUID = 1L;

    public Long getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(Long idVersion) {
        this.idVersion = idVersion;
    }

    public Integer getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(Integer majorVersion) {
        this.majorVersion = majorVersion;
    }

    public Integer getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(Integer minorVersion) {
        this.minorVersion = minorVersion;
    }

    public Date getUpgradeDate() {
        return upgradeDate;
    }

    public void setUpgradeDate(Date upgradeDate) {
        this.upgradeDate = upgradeDate;
    }

    public Boolean getIsUpgrade() {
        return isUpgrade;
    }

    public void setIsUpgrade(Boolean isUpgrade) {
        this.isUpgrade = isUpgrade;
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
        RVersion other = (RVersion) that;
        return (this.getIdVersion() == null ? other.getIdVersion() == null : this.getIdVersion().equals(other.getIdVersion()))
            && (this.getMajorVersion() == null ? other.getMajorVersion() == null : this.getMajorVersion().equals(other.getMajorVersion()))
            && (this.getMinorVersion() == null ? other.getMinorVersion() == null : this.getMinorVersion().equals(other.getMinorVersion()))
            && (this.getUpgradeDate() == null ? other.getUpgradeDate() == null : this.getUpgradeDate().equals(other.getUpgradeDate()))
            && (this.getIsUpgrade() == null ? other.getIsUpgrade() == null : this.getIsUpgrade().equals(other.getIsUpgrade()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdVersion() == null) ? 0 : getIdVersion().hashCode());
        result = prime * result + ((getMajorVersion() == null) ? 0 : getMajorVersion().hashCode());
        result = prime * result + ((getMinorVersion() == null) ? 0 : getMinorVersion().hashCode());
        result = prime * result + ((getUpgradeDate() == null) ? 0 : getUpgradeDate().hashCode());
        result = prime * result + ((getIsUpgrade() == null) ? 0 : getIsUpgrade().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idVersion=").append(idVersion);
        sb.append(", majorVersion=").append(majorVersion);
        sb.append(", minorVersion=").append(minorVersion);
        sb.append(", upgradeDate=").append(upgradeDate);
        sb.append(", isUpgrade=").append(isUpgrade);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}