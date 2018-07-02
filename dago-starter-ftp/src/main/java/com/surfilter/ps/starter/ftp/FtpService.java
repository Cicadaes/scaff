package com.surfilter.ps.starter.ftp;
/**
 * All rights Reserved, Designed By www.1218.com.cn
 *
 * @version V1.0
 * @Title: FtpService
 * @Package PACKAGE_NAME
 * @Description:
 * @author: Alex
 * @date: 2018-07-02 下午9:52
 * @Copyright: 2018 www.1218.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于任子行网络技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class FtpService {
    private String msg;

    public String sayHello(){
        return "Hello "+msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    };
}
