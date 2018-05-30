package com.surfilter.ps.model;

import java.io.Serializable;

/**
 * r_slave
 * @author 
 */
public class RSlave implements Serializable {
    private Long idSlave;

    private String name;

    private String hostName;

    private String port;

    private String webAppName;

    private String username;

    private String password;

    private String proxyHostName;

    private String proxyPort;

    private String nonProxyHosts;

    private Boolean master;

    private static final long serialVersionUID = 1L;

    public Long getIdSlave() {
        return idSlave;
    }

    public void setIdSlave(Long idSlave) {
        this.idSlave = idSlave;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getWebAppName() {
        return webAppName;
    }

    public void setWebAppName(String webAppName) {
        this.webAppName = webAppName;
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

    public String getProxyHostName() {
        return proxyHostName;
    }

    public void setProxyHostName(String proxyHostName) {
        this.proxyHostName = proxyHostName;
    }

    public String getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(String proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getNonProxyHosts() {
        return nonProxyHosts;
    }

    public void setNonProxyHosts(String nonProxyHosts) {
        this.nonProxyHosts = nonProxyHosts;
    }

    public Boolean getMaster() {
        return master;
    }

    public void setMaster(Boolean master) {
        this.master = master;
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
        RSlave other = (RSlave) that;
        return (this.getIdSlave() == null ? other.getIdSlave() == null : this.getIdSlave().equals(other.getIdSlave()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getHostName() == null ? other.getHostName() == null : this.getHostName().equals(other.getHostName()))
            && (this.getPort() == null ? other.getPort() == null : this.getPort().equals(other.getPort()))
            && (this.getWebAppName() == null ? other.getWebAppName() == null : this.getWebAppName().equals(other.getWebAppName()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getProxyHostName() == null ? other.getProxyHostName() == null : this.getProxyHostName().equals(other.getProxyHostName()))
            && (this.getProxyPort() == null ? other.getProxyPort() == null : this.getProxyPort().equals(other.getProxyPort()))
            && (this.getNonProxyHosts() == null ? other.getNonProxyHosts() == null : this.getNonProxyHosts().equals(other.getNonProxyHosts()))
            && (this.getMaster() == null ? other.getMaster() == null : this.getMaster().equals(other.getMaster()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdSlave() == null) ? 0 : getIdSlave().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getHostName() == null) ? 0 : getHostName().hashCode());
        result = prime * result + ((getPort() == null) ? 0 : getPort().hashCode());
        result = prime * result + ((getWebAppName() == null) ? 0 : getWebAppName().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getProxyHostName() == null) ? 0 : getProxyHostName().hashCode());
        result = prime * result + ((getProxyPort() == null) ? 0 : getProxyPort().hashCode());
        result = prime * result + ((getNonProxyHosts() == null) ? 0 : getNonProxyHosts().hashCode());
        result = prime * result + ((getMaster() == null) ? 0 : getMaster().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idSlave=").append(idSlave);
        sb.append(", name=").append(name);
        sb.append(", hostName=").append(hostName);
        sb.append(", port=").append(port);
        sb.append(", webAppName=").append(webAppName);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", proxyHostName=").append(proxyHostName);
        sb.append(", proxyPort=").append(proxyPort);
        sb.append(", nonProxyHosts=").append(nonProxyHosts);
        sb.append(", master=").append(master);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}