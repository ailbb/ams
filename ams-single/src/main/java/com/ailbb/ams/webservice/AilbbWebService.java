package com.ailbb.ams.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface AilbbWebService {

    @WebMethod
    List<String> sayHello(@WebParam(name = "str") String str);

    @WebMethod
    List<String> sayHi(@WebParam(name = "str") String str);

}
