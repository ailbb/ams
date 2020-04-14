package com.ailbb.ams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


/**
 * Created by Wz on 5/15/2018.
 */
@EnableHystrix // 断路器，避免调用服务产生连锁故障
@EnableHystrixDashboard // 断路仪表监控器，地址为：/hystrix
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class, // 排除自动加载数据库（防止启动报错）
        EurekaClientAutoConfiguration.class // 关闭自动发现注册功能，作为单web程序使用
}) // SpringBoot程序
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
