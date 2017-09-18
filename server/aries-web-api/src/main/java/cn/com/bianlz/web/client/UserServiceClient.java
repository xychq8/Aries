package cn.com.bianlz.web.client;

import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.user.api.user.Role;
import cn.com.bianlz.user.api.user.User;
import cn.com.bianlz.web.common.ServiceHelper;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * Created by bianlanzhou on 17/9/10.
 * Description
 */
@FeignClient(name = ServiceHelper.USER_SERVICE)
public interface UserServiceClient {

    @PostMapping("/user/auth/login")
    public Result login(@RequestBody Map<String,String> param);

    @RequestMapping(value="/user/auth/token/{token}",method = RequestMethod.GET)
    public Result<User> getUserByToken(@PathVariable("token") String token);

    @RequestMapping(value="/user/menu/rid/{rid}",method = RequestMethod.GET)
    public Result getMenu(@PathVariable("rid") Long rid);

    @RequestMapping(value="/user/list/roleId/{roleId}",method = RequestMethod.GET)
    public Result getUserByRoleId(@PathVariable("roleId") Long roleId);

    @RequestMapping(value="/user/update")
    public Result updateUser(@RequestBody User user);

    @RequestMapping(value = "/user/role/sub/{roleId}",method = RequestMethod.GET)
    public Result<List<Role>> getSubRole(@PathVariable("roleId") Long id);


    @RequestMapping(value = "/user/menu/get",method = RequestMethod.GET)
    public Result<Map<String,Object>> getUserMenu(@RequestParam("rid")Long rid,@RequestParam("uRid")Long uRid);
}
