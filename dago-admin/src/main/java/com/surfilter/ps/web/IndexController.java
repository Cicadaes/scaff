package com.surfilter.ps.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * All rights Reserved, Designed By www.1218.com.cn
 *
 * @version V1.0
 * @Title: IndexController
 * @Package com.surfilter.ps.web
 * @Description:
 * @author: Alex
 * @date: 2018-07-12 下午7:02
 * @Copyright: 2018 www.1218.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于任子行网络技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
public class IndexController {

    @RequestMapping("/toLogin")
    public String toLogin(Model model, HttpServletRequest request) {
//        if (loginService.ifLogin(request) != null) {
//            return "redirect:/";
//        }
        return "login";
    }

    @RequestMapping("/")
    public String index(Model model, HttpServletRequest request) {
        return "redirect:/toMain";
    }

    @RequestMapping("/toMain")
    public String main(Model model, HttpServletRequest request) {
        return "main";
    }

    @RequestMapping(value="login", method= RequestMethod.POST)
    @ResponseBody
    public ReturnT<String> loginDo(HttpServletRequest request, HttpServletResponse response, String userName, String password, String ifRemember){
        // valid
        if (loginService.ifLogin(request) != null) {
            return ReturnT.SUCCESS;
        }

        // param
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)){
            return new ReturnT<String>(500, "账号或密码为空");
        }
        boolean ifRem = (StringUtils.isNotBlank(ifRemember) && "on".equals(ifRemember))?true:false;

        // do login
        return loginService.login(response, userName, password, ifRem);
    }
}
