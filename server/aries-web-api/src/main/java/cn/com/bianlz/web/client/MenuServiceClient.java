package cn.com.bianlz.web.client;

import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.web.common.ServiceHelper;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;


/**
 * Created by bianlanzhou on 17/9/10.
 * Description
 */
@FeignClient(name = ServiceHelper.SERVICE_LOGIN)
public interface MenuServiceClient {
    @RequestMapping(value="/menu",method = RequestMethod.GET)
    public Result getMenu(@RequestParam("token") String token);
}
