package com.surfilter.ps.starter.ftp;

import java.lang.annotation.*;

/**
 * All rights Reserved, Designed By www.1218.com.cn
 *
 * @version V1.0
 * @Title: TargetFtpDataSource
 * @Package com.surfilter.ps.starter.ftp
 * @Description:
 * @author: Alex
 * @date: 2018-07-08 上午9:26
 * @Copyright: 2018 www.1218.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于任子行网络技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Target({ ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetFtpDataSource {

    int value();
}
