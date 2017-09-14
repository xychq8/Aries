package cn.com.bianlz.web.common;

import cn.com.bianlz.common.utils.GsonUtils;
import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.user.api.user.User;
import cn.com.bianlz.web.HttpCodeUtils;
import cn.com.bianlz.web.client.LoginServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bianlanzhou on 17/9/13.
 * Description
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private LoginServiceClient loginServiceClient;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Authorizition auth = handlerMethod.getBeanType().getAnnotation(Authorizition.class);
            if(auth!=null&&auth.auth()){
                String token = request.getHeader("token");
                if(token==null){
                    HttpCodeUtils.set302(response,"/");
                    return false;
                }
                Result<User> result = loginServiceClient.getUserByToken(token);
                if(result==null||result.getData()==null){
                    HttpCodeUtils.set302(response,"/");
                    return false;
                }
                User user = result.getData();
                request.getSession().setAttribute("user",user);
                return false;
            }
        }
        return super.preHandle(request, response, handler);
    }


}
