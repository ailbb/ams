import com.ailbb.ajj.$;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Wz on 5/9/2018.
 */
public class HelloJava {
    public static void main(String[] args) throws Exception {
        String cr = "* * 0/1 * * ? *";
//        String cr = "0 0 0/1 * * ? *";

        List<Date> dates = $.date.cron.init(cr.substring(0, cr.lastIndexOf("*")).trim()).ranges($.date.parse("2018-10-23 00:00:00"), $.date.parse("2018-10-23 05:00:00"));

        System.out.println(dates);
        /*
        $.post("http://localhost:30002/actuator/refresh");
        List<String> uris = Arrays.asList("/rest/forezp/article/details/69788938".split("/"));

        String serviceName = uris.get(2); // 获取服务名

        uris = uris.subList(3, uris.size()); // 获取路径

        $.sout($.url($.concat(serviceName, "/", $.join(uris, "/"))));*/
    }
}
