package cn.com.bianlz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


/**
 * Created by bianlanzhou on 17/9/27.
 * Description
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("cn.com.bianlz.dao")
public class App {
    public static void main(String[] args) {
        new SpringApplicationBuilder(App.class).web(false).run();
    }

    @Bean(name="txManager")
    @ConditionalOnMissingBean
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
