package com.ailbb.ams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Wz on 5/15/2018.
 */
//@EnableConfigServer // SpringBoot Server：声明此服务为分布式配置服务中心，服务端使用
//@EnableEurekaServer // SpringBoot Server：启用注册服务中心，默认服务中心也是一个客户端
//@EnableEurekaClient // SpringBoot Client：表明是客户端，基于spring-cloud-netflix，eureka作为注册中心的时候使用
@EnableDiscoveryClient // SpringBoot Client：表明是客户端，其他注册中心通用
@EnableZuulProxy // 路由转发和过滤器
@EnableHystrix // 断路器，避免调用服务产生连锁故障
@EnableHystrixDashboard // 断路仪表监控器，地址为：/hystrix
@EnableFeignClients // 声明式的伪Http客户端，具有可插拔的注解特性，可使用Feign 注解和JAX-RS注解，默认集成了Ribbon
//@RefreshScope // SpringBoot Client：在附带@Value的页面加上此注解@RefreshScope，进行动态刷新配置，允许动态刷新
//@EnableRedisHttpSession(redisFlushMode = RedisFlushMode.IMMEDIATE)
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class, // 排除自动加载数据库（防止启动报错）
//        EurekaClientAutoConfiguration.class // 关闭自动发现注册功能，作为单web程序使用
}) // SpringBoot程序
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // RestTemplate负载均衡服务
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
