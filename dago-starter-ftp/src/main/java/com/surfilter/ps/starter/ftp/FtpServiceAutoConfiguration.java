package com.surfilter.ps.starter.ftp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
@EnableConfigurationProperties(FtpServiceProperties.class)
@ConditionalOnClass(FtpService.class)
@ConditionalOnProperty(prefix="ftp",value="enabled",matchIfMissing=true)
public class FtpServiceAutoConfiguration {
    @Autowired
    private FtpServiceProperties ftpServiceProperties;

    @Bean
    public FtpService ftpService(){
        FtpService ftpService = new FtpService();
        ftpService.setMsg(ftpServiceProperties.getMsg());
        return ftpService;
    }
}
