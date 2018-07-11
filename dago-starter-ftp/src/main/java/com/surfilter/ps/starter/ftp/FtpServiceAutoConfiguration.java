package com.surfilter.ps.starter.ftp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.1218.com.cn
 *
 * @version V1.0
 * @Title: FtpServiceAutoConfiguration
 * @Package PACKAGE_NAME
 * @Description:
 * @author: Alex
 * @date: 2018-07-02 下午9:52
 * @Copyright: 2018 www.1218.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于任子行网络技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Configuration
@EnableConfigurationProperties(FtpStarterConfig.class)
@ConditionalOnClass(FTPClientPool.class)
@ConditionalOnProperty(prefix="dago.ftp",value="enabled",matchIfMissing=true)
public class FtpServiceAutoConfiguration {

    @Autowired
    private FtpStarterConfig starterConfig;

    @Bean
    public FTPClientPool ftpClientPool(){
        FTPConfig ftpConfig = new FTPConfig();
        FTPClientPool ftpClientPool  = new FTPClientPool(ftpConfig);
        return ftpClientPool;
    }

    public Map<Integer,FTPClientPool> ftpPools(){
        Map<Integer,FTPClientPool> ftps = new HashMap<Integer,FTPClientPool>();
        for (int i = 0; i < starterConfig.getHost().size(); i++) {
            String host =  starterConfig.getHost().get(i);
            if(starterConfig.getUsername().get(i)!=null){
                String username =  starterConfig.getUsername().get(i);
            }
            if(starterConfig.getUsername().get(i)!=null){
                String password =  starterConfig.getPassword().get(i);
            }else{
//                throw new Exception("密码必填");
            }
            //转换为连接池配置类
            FTPConfig ftpConfig = new FTPConfig();
            FTPClientPool ftpClientPool  = new FTPClientPool(ftpConfig);
//            FTPConfig ftpConfig = new FTPConfig();

        }
        return new HashMap<Integer,FTPClientPool>();
    }


}
