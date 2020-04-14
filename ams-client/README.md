#ams
Ailbb Micro Service Client. // Ailbb springcloud 微服务-客户端服务脚手架

# 技术概要:
- Maven
- Java
- Scala
- Spring Cloud
- Spring Cloud Config Client
- Spring Cloud feign/RestTemplate
- Spring Boot
- Spring MVC

# 支持
- 默认服务端口：30002

- SpringBoot & SpringCloud 升级变化及改动

    <dependencies>
    
        <!--SpringBoot & SpringCloud 升级变化及改动-->
        
        <!--Spring Boot-->
        <!--<version>1.5.13.RELEASE</version>-->
        <!--升级为-->
        <version>2.0.1.RELEASE</version>
        
        <!--Spring Cloud-->
        <!--<version.spring-cloud>Edgware.SR3</version.spring-cloud>-->
        <!--升级为-->
        <version.spring-cloud>Finchley.SR1</version.spring-cloud>

        <!--1、之前接口的访问地址进行了变更-->
        
        <!--大部分之前的接口，均放至actuator接口下，例如：-->
        <!--之前的/health变为了/actuator/health-->
        <!--/info变为了/actuator/info-->
        <!--/bus/refresh变为了/actuator/bus-refresh-->
        
        
        <!--2、pom引入的包进行了变更-->
        
        <!--Spring 注册发现服务-->
        <!--<dependency>-->
        <!--<groupId>org.springframework.cloud</groupId>-->
        <!--<artifactId>spring-cloud-starter-eureka</artifactId>-->
        <!--</dependency>-->
        <!--升级为-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>

        <!--<dependency>-->
        <!--<groupId>org.springframework.cloud</groupId>-->
        <!--<artifactId>spring-cloud-starter-eureka-server</artifactId>-->
        <!--</dependency>-->
        <!--升级为-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>


        <!--伪Http客户端负载均衡，例如：@FeignClient(value = "service-hi")，负载均衡服务：RestTemplate/Zuul/feign可以3选1-->
        <!--<dependency>-->
        <!--<groupId>org.springframework.cloud</groupId>-->
        <!--<artifactId>spring-cloud-starter-feign</artifactId>-->
        <!--</dependency>-->
        <!--升级为-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>

        <!--路由转发和过滤器，静态路由等，负载均衡服务：RestTemplate/Zuul/feign可以3选1-->
        <!--<dependency>-->
        <!--<groupId>org.springframework.cloud</groupId>-->
        <!--<artifactId>spring-cloud-starter-zuul</artifactId>-->
        <!--</dependency>-->
        <!--升级为-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
        </dependency>

        <!--断路由，防止超时死锁-->
        <!--<dependency>-->
        <!--<groupId>org.springframework.cloud</groupId>-->
        <!--<artifactId>spring-cloud-starter-hystrix</artifactId>-->
        <!--</dependency>-->
        <!--升级为-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
        </dependency>

        <!--路由状态仪表监控器，界面入口：/hystrix-->
        <!--<dependency>-->
        <!--<groupId>org.springframework.cloud</groupId>-->
        <!--<artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>-->
        <!--</dependency>-->
        <!--升级为-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
        </dependency>

    </dependencies>