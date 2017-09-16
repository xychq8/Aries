package cn.com.bianlz.web.client;

import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.user.api.user.User;
import cn.com.bianlz.web.common.ServiceHelper;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by bianlanzhou on 17/9/10.
 * Description
 */
@FeignClient(name = ServiceHelper.USER_SERVICE)
public interface UserServiceClient {
    @RequestMapping(value="/user/list/roleId/{roleId}",method = RequestMethod.GET)
    public Result getUserByRoleId(@PathVariable("roleId") Long roleId);

    @RequestMapping(value="/user/update")
    public Result updateUser(@RequestBody User user);
}
