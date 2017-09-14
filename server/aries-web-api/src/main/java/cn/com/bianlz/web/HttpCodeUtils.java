package cn.com.bianlz.web;

import cn.com.bianlz.common.utils.GsonUtils;
import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.web.common.WebApiProtocolCode;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bianlanzhou on 17/9/14.
 * Description
 */
public class HttpCodeUtils {

    public static void set403(HttpServletResponse response){
        response.setStatus(403);
        Result result = new Result();
        result.setCode(WebApiProtocolCode.AUTH_FAIL.getCode());
        result.setMessage(WebApiProtocolCode.AUTH_FAIL.getMessage());
        try {
            response.getWriter().print(GsonUtils.getInstances().toJson(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void set302(HttpServletResponse response,String path){
        response.setStatus(302);
        if(path!=null){
            response.setHeader("path",path);
        }
    }
}
