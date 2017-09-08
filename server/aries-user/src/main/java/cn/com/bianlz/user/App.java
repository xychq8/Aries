package cn.com.bianlz.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by bianlanzhou on 17/9/1.
 * Description
 */
@SpringBootApplication
@MapperScan("cn.com.bianlz.user.mapper")
@EnableDiscoveryClient
public class App {
    public static void main(String[] args) {
        new SpringApplicationBuilder(App.class).web(true).run(args);
    }
}
