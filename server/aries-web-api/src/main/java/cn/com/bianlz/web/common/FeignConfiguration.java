package cn.com.bianlz.web.common;

import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by bianlanzhou on 17/11/7.
 * Description
 */
@Configuration
public class FeignConfiguration {
    @Bean
    public Request.Options options(){
        return new Request.Options(
                1000,
                10000
        );
    }
    @Bean
    public Retryer retryer(){
        return new Retryer.Default(1000,10000,2);
    }
}
