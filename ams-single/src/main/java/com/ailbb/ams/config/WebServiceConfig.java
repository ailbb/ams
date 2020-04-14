package com.ailbb.ams.config;


import com.ailbb.ams.webservice.AilbbWebService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {
    @Autowired
    AilbbWebService ailbbWebService;

    /**
     * 注入servlet  bean name不能dispatcherServlet 否则会覆盖dispatcherServlet
     * @return
     */
    @Bean(name = Bus.DEFAULT_BUS_ID+"Servlet")
    public ServletRegistrationBean cxfServlet() {
        return new ServletRegistrationBean(new CXFServlet(),"/webservice/*");
    }


    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    /**
     * 注册QueryServiceEndpoint接口到webservice服务
     * @return
     */
    @Bean(name = "QueryServiceEndpoint")
    public Endpoint queryServiceEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), ailbbWebService);
        endpoint.publish("/ailbb");
        return endpoint;
    }

}
