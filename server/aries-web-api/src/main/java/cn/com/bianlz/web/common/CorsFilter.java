package cn.com.bianlz.web.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bianlanzhou on 17/9/9.
 * Description
 */
@Configuration
@WebFilter("/api")
public class CorsFilter extends OncePerRequestFilter{
    @Autowired
    private Environment env;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        // Access-Control-Allow-Origin: 指定授权访问的域
        httpServletResponse.addHeader("Access-Control-Allow-Origin",env.getProperty("host") );  //此优先级高于@CrossOrigin配置
        // Access-Control-Allow-Methods: 授权请求的方法（GET, POST, PUT, DELETE，OPTIONS等)
        httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        httpServletResponse.addHeader("Access-Control-Allow-Headers", "Content-Type");
        httpServletResponse.addHeader("Access-Control-Allow-Headers", "token");
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
