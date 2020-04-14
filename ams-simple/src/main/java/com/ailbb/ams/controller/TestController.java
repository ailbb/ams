package com.ailbb.ams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.StringTokenizer;

/**
 * Created by Wz on 5/30/2018.
 */
@RestController
@RequestMapping
public class TestController {
    public static long count = 0;

    @RequestMapping(value = {"/*/**"})
    @ResponseBody
    public String index(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
        String Agent = request.getHeader("User-Agent");
        System.out.println("//Agent信息：" + Agent);

        StringTokenizer st = new StringTokenizer(Agent,";");
        try {
            st.nextToken();

            String userbrowser = st.nextToken();
            System.out.println("//得到用户的浏览器名：" + userbrowser);

            String useros = st.nextToken();
            System.out.println("//操作系统名：" + useros);

        } catch (Exception e) {}

        System.out.println("获得客户端向服务器端传送数据的方法有GET、POST、PUT等类型："+request. getMethod());
        System.out.println("获得发出请求字符串的客户端地址："+request. getRequestURI());
        System.out.println("获得客户端所请求的脚本文件的文件路径："+request. getServletPath());
        System.out.println("获得服务器的名字："+request. getServerName());
        System.out.println("获得服务器的端口号："+request.getServerPort());
        System.out.println("获得客户端的IP地址："+request.getRemoteAddr());
        System.out.println("获得客户端电脑的名字，若失败，则返回客户端电脑的IP地址："+request.getRemoteHost());
        System.out.println("返回所有requestheader的名字，结果集是一个Enumeration（枚举）类的实例："+request.getProtocol() + "-----" + request.getHeaderNames());

        Enumeration<String> headers =  request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String s = headers.nextElement();
            Enumeration<String> _list = request.getHeaders(s);

            System.out.println("//Header - " + s);

            while (_list.hasMoreElements()) {
                System.out.println("//HeaderChild - " + _list.nextElement());
            }
        }

        System.out.println((TestController.count++) + "个进程挂起中..." );

        long t = 30; // 模拟等待10分钟
        while(t-->0) {
            try {
                Thread.sleep(1000*60); // 挂1分钟
            } catch (Exception e) {
                System.out.println("挂起异常");
            }
        }

        TestController.count--;

        System.out.println("---结束--");
        System.out.println("---结束--");
        System.out.println("---结束--");
        System.out.println("---结束--");
        System.out.println("---结束--");

        return "{\"result\": \"SUCCESS\"}";
    }

}
