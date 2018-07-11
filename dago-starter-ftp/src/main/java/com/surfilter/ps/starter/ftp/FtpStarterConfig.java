package com.surfilter.ps.starter.ftp;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * All rights Reserved, Designed By www.1218.com.cn
 *
 * @version V1.0
 * @Title: FtpStarterConfig
 * @Package com.surfilter.ps.starter.ftp
 * @Description: ftp start配置文件对象
 * @author: Alex
 * @date: 2018-07-07 下午2:06
 * @Copyright: 2018 www.1218.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于任子行网络技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@ConfigurationProperties(prefix = "dago.ftp")
public class FtpStarterConfig {

    private List<String> host = new ArrayList<>();

    private List<String> username = new ArrayList<>();

    private List<String> password = new ArrayList<>();

    private int maxTotal;

    private int maxIdle;

    private int minIdle;

    private int initSize;

    public List<String> getHost() {
        return host;
    }

    public void setHost(List<String> host) {
        this.host = host;
    }

    public List<String> getUsername() {
        return username;
    }

    public void setUsername(List<String> username) {
        this.username = username;
    }

    public List<String> getPassword() {
        return password;
    }

    public void setPassword(List<String> password) {
        this.password = password;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public int getInitSize() {
        return initSize;
    }

    public void setInitSize(int initSize) {
        this.initSize = initSize;
    }
}
