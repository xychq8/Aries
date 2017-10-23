package cn.com.bianlz.web;

import cn.com.bianlz.web.common.AuthInterceptor;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by bianlanzhou on 17/9/8.
 * Description
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class App {
    private static ApplicationContext applicationContext ;
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        applicationContext = new SpringApplicationBuilder(App.class).web(true).run(args);
    }

    public static <T> T getBean(Class T,String name){
        return (T)applicationContext.getBean(name);
    }
    @Configuration
    static class WebMvcConfigurer extends WebMvcConfigurerAdapter {

        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**");
        }
    }

}
