package com.surfilter.ps.core;

import org.apache.commons.exec.*;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * All rights Reserved, Designed By www.1218.com.cn
 *
 * @version V1.0
 * @Title: CommonUtil
 * @Package com.surfilter.ps
 * @Description:
 * @author: Alex
 * @date: 2018-08-11 下午2:50
 * @Copyright: 2018 www.1218.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于任子行网络技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class CommonUtil {

    /**
     * 执行不需要返回结果的命令
     * @throws Exception
     */
    public void execCmdWithoutResult(String command,String[] params,String charset) throws Exception{
        //开启windows telnet: net start telnet
        //注意：第一个空格之后的所有参数都为参数
        CommandLine cmdLine = new CommandLine("net");
        cmdLine.addArgument("start");
        cmdLine.addArgument("telnet");
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(1);
        //设置60秒超时，执行超过60秒后会直接终止
        ExecuteWatchdog watchdog = new ExecuteWatchdog(60 * 1000);
        executor.setWatchdog(watchdog);
        DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
        executor.execute(cmdLine, handler);
        //命令执行返回前一直阻塞
        handler.waitFor();
    }

    /**
     * 带返回结果的命令执行
     * @return
     */
    public Map<String,String> execCmdWithResult(String command, String charset) {
        Map<String,String> msg = new HashMap<String,String>();
        try {
            //接收正常结果流
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            //接收异常结果流
            ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
            CommandLine commandline = CommandLine.parse(command);
            DefaultExecutor exec = new DefaultExecutor();
            exec.setExitValues(null);
            //设置一分钟超时
            ExecuteWatchdog watchdog = new ExecuteWatchdog(60*1000);
            exec.setWatchdog(watchdog);
            PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream,errorStream);
            exec.setStreamHandler(streamHandler);
            exec.execute(commandline);
            //不同操作系统注意编码，否则结果乱码

            String out = outputStream.toString(charset);
            String error = errorStream.toString(charset);
            msg.put("out",out);
            msg.put("error",error);
            return msg;
        } catch (Exception e) {
            e.printStackTrace();
            msg.put("error",e.getMessage());
            return msg;
        }
    }

    public void all() {
        Properties props = System.getProperties();
        System.out.println("Java的执行环境版本号：" + props.getProperty("java.version"));
        System.out.println("Java的执行环境供应商：" + props.getProperty("java.vendor"));
        System.out.println("Java供应商的URL：" + props.getProperty("java.vendor.url"));
        System.out.println("Java的安装路径：" + props.getProperty("java.home"));
        System.out.println("Java的虚拟机规范版本号：" + props.getProperty("java.vm.specification.version"));
        System.out.println("Java的虚拟机规范供应商：" + props.getProperty("java.vm.specification.vendor"));
        System.out.println("Java的虚拟机规范名称：" + props.getProperty("java.vm.specification.name"));
        System.out.println("Java的虚拟机实现版本号：" + props.getProperty("java.vm.version"));
        System.out.println("Java的虚拟机实现供应商：" + props.getProperty("java.vm.vendor"));
        System.out.println("Java的虚拟机实现名称：" + props.getProperty("java.vm.name"));
        System.out.println("Java执行时环境规范版本号：" + props.getProperty("java.specification.version"));
        System.out.println("Java执行时环境规范供应商：" + props.getProperty("java.specification.vender"));
        System.out.println("Java执行时环境规范名称：" + props.getProperty("java.specification.name"));
        System.out.println("Java的类格式版本号号：" + props.getProperty("java.class.version"));
        System.out.println("Java的类路径：" + props.getProperty("java.class.path"));
        System.out.println("载入库时搜索的路径列表：" + props.getProperty("java.library.path"));
        System.out.println("默认的暂时文件路径：" + props.getProperty("java.io.tmpdir"));
        System.out.println("一个或多个扩展文件夹的路径：" + props.getProperty("java.ext.dirs"));
        System.out.println("操作系统的名称：" + props.getProperty("os.name"));
        System.out.println("操作系统的构架：" + props.getProperty("os.arch"));
        System.out.println("操作系统的版本号：" + props.getProperty("os.version"));
        System.out.println("文件分隔符：" + props.getProperty("file.separator"));
        //在 unix 系统中是＂／＂
        System.out.println("路径分隔符：" + props.getProperty("path.separator"));
        //在 unix 系统中是＂:＂
        System.out.println("行分隔符：" + props.getProperty("line.separator"));
        //在 unix 系统中是＂/n＂
        System.out.println("用户的账户名称：" + props.getProperty("user.name"));
        System.out.println("用户的主文件夹：" + props.getProperty("user.home"));
        System.out.println("用户的当前工作文件夹：" + props.getProperty("user.dir"));
    }

    public static void main(String [] ages){
        CommonUtil util = new CommonUtil();
        util.all();
        Map<String,String> msg = util.execCmdWithResult("df -h","utf-8");
        System.out.println(msg.get("out"));
        System.out.println(msg.get("err"));
    }

}
