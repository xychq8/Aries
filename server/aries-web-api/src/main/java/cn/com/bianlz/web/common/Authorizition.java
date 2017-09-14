package cn.com.bianlz.web.common;

import java.lang.annotation.*;
/**
 * Created by bianlanzhou on 17/9/13.
 * Description
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Authorizition {
    boolean auth() default false;
}
