package com.ailbb.ams.webservice.impl;

import com.ailbb.ams.webservice.AilbbWebService;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.Arrays;
import java.util.List;

@Service
@WebService(serviceName = "AilbbWebService", // 与接口中指定的name一致
        targetNamespace = "http://ailbbwebservice.service.ailbb.com", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.ailbb.ams.webservice.AilbbWebService") // 接口地址

public class AilbbWebServiceImpl implements AilbbWebService {

    @Override
    public List<String> sayHello(String str) {
        return Arrays.asList(str);
    }

    @Override
    public List<String> sayHi(String str) {
        return Arrays.asList(str);
    }
}
