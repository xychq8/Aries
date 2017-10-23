package cn.com.bianlz.web.common;

import cn.com.bianlz.common.utils.GsonUtils;
import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.user.api.user.User;
import cn.com.bianlz.web.App;
import cn.com.bianlz.web.HttpCodeUtils;
import cn.com.bianlz.web.client.UserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bianlanzhou on 17/9/13.
 * Description
 */
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserServiceClient userServiceClient = App.getBean(UserServiceClient.class,"userServiceClient");
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Authorizition auth = handlerMethod.getBeanType().getAnnotation(Authorizition.class);
            User user = null;
            String token = request.getHeader("token");
            if(token!=null){
                Result<User> result = userServiceClient.getUserByToken(token);
                user = result.getData();
            }
            if(auth!=null&&auth.auth()){
                if(user==null){
                    HttpCodeUtils.set403(response);
                    return false;
                }
            }
            request.getSession().setAttribute("user",user);
        }
        return super.preHandle(request, response, handler);
    }



}
