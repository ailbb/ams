package com.ailbb.ams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Created by Wz on 5/15/2018.
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class, // 排除自动加载数据库（防止启动报错）
}) // SpringBoot程序
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
