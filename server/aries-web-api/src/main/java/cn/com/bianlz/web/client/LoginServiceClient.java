package cn.com.bianlz.web.client;

import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.web.common.ServiceHelper;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by bianlanzhou on 17/9/8.
 * Description
 */
@FeignClient(name = ServiceHelper.SERVICE_LOGIN)
public interface LoginServiceClient {
    @PostMapping("/user/auth/login")
    public Result login(@RequestBody Map<String,String> param);
    @RequestMapping(value="/user/auth/token/{token}",method = RequestMethod.GET)
    public Result getUserByToken(@PathVariable("token") String token);
}
