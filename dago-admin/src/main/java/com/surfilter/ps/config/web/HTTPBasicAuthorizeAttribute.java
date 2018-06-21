package com.surfilter.ps.config.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HTTPBasicAuthorizeAttribute implements Filter {

    private static String Name = "test";
    private static String Password = "test";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String sessionAuth = (String) req.getSession().getAttribute("auth");

        if (sessionAuth != null) {
            chain.doFilter(request, response);
        } else {
            Integer resultStatusCode = checkHTTPBasicAuthorize(request);
            if(resultStatusCode != 200){
                resp.setStatus(401);
                resp.setHeader("Cache-Control", "no-store");
                resp.setDateHeader("Expires", 0);
                resp.setHeader("WWW-authenticate", "Basic Realm=\"test\"");
            }else{
                chain.doFilter(request, response);
            }

        }
//
//        if (resultStatusCode != 200){
//            HttpServletResponse httpResponse = (HttpServletResponse) response;
//            httpResponse.setCharacterEncoding("UTF-8");
//            httpResponse.setContentType("application/json; charset=utf-8");
//            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            ObjectMapper mapper = new ObjectMapper();
//            ResultMsg resultMsg = new ResultMsg(401, "拒绝访问", null);
//            httpResponse.getWriter().write(mapper.writeValueAsString(resultMsg));
//            return;
//        }
//        else
//        {
//            chain.doFilter(request, response);
//        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
//        System.out.println("init");
    }

    @Override
    public void destroy() {
//        System.out.println("destroy");
    }

    private Integer checkHTTPBasicAuthorize(ServletRequest request){
        try{
            HttpServletRequest httpRequest = (HttpServletRequest)request;
            String auth = httpRequest.getHeader("Authorization");
            if ((auth != null) && (auth.length() > 6))
            {
                String HeadStr = auth.substring(0, 5).toLowerCase();
                if (HeadStr.compareTo("basic") == 0)
                {
                    auth = auth.substring(6, auth.length());
                    String decodedAuth = getFromBASE64(auth);
                    if (decodedAuth != null)
                    {
                        String[] UserArray = decodedAuth.split(":");

                        if (UserArray != null && UserArray.length == 2)
                        {
                            if (UserArray[0].compareTo(Name) == 0
                                    && UserArray[1].compareTo(Password) == 0)
                            {
                                return ResultStatusCode.OK;
                            }
                        }
                    }
                }
            }
            return ResultStatusCode.PERMISSION_DENIED;
        }
        catch(Exception ex)
        {
            return ResultStatusCode.PERMISSION_DENIED;
        }
    }

    private String getFromBASE64(String s) {
        if (s == null) {
            return null;
        }
//        BASE64Decoder decoder = new BASE64Decoder();
        try {
//            byte[] b = decoder.decodeBuffer(s);
//            return new String(b);
            return "";
        } catch (Exception e) {
            return null;
        }
    }
}
