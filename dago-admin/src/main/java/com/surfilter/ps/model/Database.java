package com.surfilter.ps.model;

public class Database {
    private Long idDatabase;

    private String name;

    private Integer idDatabaseType;

    private Integer idDatabaseContype;

    private String hostName;

    private Integer port;

    private String username;

    private String password;

    private String servername;

    private String dataTbs;

    private String indexTbs;

    private String databaseName;

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
        this.name = name == null ? null : name.trim();
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
        this.hostName = hostName == null ? null : hostName.trim();
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
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getServername() {
        return servername;
    }

    public void setServername(String servername) {
        this.servername = servername == null ? null : servername.trim();
    }

    public String getDataTbs() {
        return dataTbs;
    }

    public void setDataTbs(String dataTbs) {
        this.dataTbs = dataTbs == null ? null : dataTbs.trim();
    }

    public String getIndexTbs() {
        return indexTbs;
    }

    public void setIndexTbs(String indexTbs) {
        this.indexTbs = indexTbs == null ? null : indexTbs.trim();
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName == null ? null : databaseName.trim();
    }
}