package com.surfilter.ps.kettle.entity;

import java.io.Serializable;

/**
 * r_database
 * @author 
 */
public class Database implements Serializable {
    /**
     * 主键
     */
    private Long idDatabase;

    /**
     * 连接源名称
     */
    private String name;

    /**
     * 连接源类别
     */
    private Integer idDatabaseType;

    /**
     * 数据库连接方式
     */
    private Integer idDatabaseContype;

    /**
     * 连接源地址
     */
    private String hostName;

    /**
     * 端口
     */
    private Integer port;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 服务名
     */
    private String servername;

    private String dataTbs;

    private String indexTbs;

    private String databaseName;

    private static final long serialVersionUID = 1L;

    public Long getIdDatabase() {
        return idDatabase;
    }

    public void setIdDatabase(Long idDatabase) {
        this.idDatabase = idDatabase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdDatabaseType() {
        return idDatabaseType;
    }

    public void setIdDatabaseType(Integer idDatabaseType) {
        this.idDatabaseType = idDatabaseType;
    }

    public Integer getIdDatabaseContype() {
        return idDatabaseContype;
    }

    public void setIdDatabaseContype(Integer idDatabaseContype) {
        this.idDatabaseContype = idDatabaseContype;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServername() {
        return servername;
    }

    public void setServername(String servername) {
        this.servername = servername;
    }

    public String getDataTbs() {
        return dataTbs;
    }

    public void setDataTbs(String dataTbs) {
        this.dataTbs = dataTbs;
    }

    public String getIndexTbs() {
        return indexTbs;
    }

    public void setIndexTbs(String indexTbs) {
        this.indexTbs = indexTbs;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
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
        Database other = (Database) that;
        return (this.getIdDatabase() == null ? other.getIdDatabase() == null : this.getIdDatabase().equals(other.getIdDatabase()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getIdDatabaseType() == null ? other.getIdDatabaseType() == null : this.getIdDatabaseType().equals(other.getIdDatabaseType()))
            && (this.getIdDatabaseContype() == null ? other.getIdDatabaseContype() == null : this.getIdDatabaseContype().equals(other.getIdDatabaseContype()))
            && (this.getHostName() == null ? other.getHostName() == null : this.getHostName().equals(other.getHostName()))
            && (this.getPort() == null ? other.getPort() == null : this.getPort().equals(other.getPort()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getServername() == null ? other.getServername() == null : this.getServername().equals(other.getServername()))
            && (this.getDataTbs() == null ? other.getDataTbs() == null : this.getDataTbs().equals(other.getDataTbs()))
            && (this.getIndexTbs() == null ? other.getIndexTbs() == null : this.getIndexTbs().equals(other.getIndexTbs()))
            && (this.getDatabaseName() == null ? other.getDatabaseName() == null : this.getDatabaseName().equals(other.getDatabaseName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdDatabase() == null) ? 0 : getIdDatabase().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getIdDatabaseType() == null) ? 0 : getIdDatabaseType().hashCode());
        result = prime * result + ((getIdDatabaseContype() == null) ? 0 : getIdDatabaseContype().hashCode());
        result = prime * result + ((getHostName() == null) ? 0 : getHostName().hashCode());
        result = prime * result + ((getPort() == null) ? 0 : getPort().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getServername() == null) ? 0 : getServername().hashCode());
        result = prime * result + ((getDataTbs() == null) ? 0 : getDataTbs().hashCode());
        result = prime * result + ((getIndexTbs() == null) ? 0 : getIndexTbs().hashCode());
        result = prime * result + ((getDatabaseName() == null) ? 0 : getDatabaseName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idDatabase=").append(idDatabase);
        sb.append(", name=").append(name);
        sb.append(", idDatabaseType=").append(idDatabaseType);
        sb.append(", idDatabaseContype=").append(idDatabaseContype);
        sb.append(", hostName=").append(hostName);
        sb.append(", port=").append(port);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", servername=").append(servername);
        sb.append(", dataTbs=").append(dataTbs);
        sb.append(", indexTbs=").append(indexTbs);
        sb.append(", databaseName=").append(databaseName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}