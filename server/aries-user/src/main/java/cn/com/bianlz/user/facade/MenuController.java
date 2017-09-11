package cn.com.bianlz.user.facade;

import cn.com.bianlz.common.utils.GsonUtils;
import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.user.api.menu.Menu;
import cn.com.bianlz.user.api.user.User;
import cn.com.bianlz.user.common.RedisKeys;
import cn.com.bianlz.user.common.UserProtocolCode;
import cn.com.bianlz.user.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bianlanzhou on 17/9/10.
 * Description
 */
@RestController
public class MenuController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private MenuService menuService;
    @GetMapping("/menu/token/{token}")
    public Result getMenu(@PathVariable("token") String token){
        Result<List<Menu>> result = new Result<List<Menu>>();
        result.setCode(UserProtocolCode.SUCCESS.getCode());
        Object userObj = redisTemplate.opsForValue().get(RedisKeys.TOKEN+token);
        if(userObj == null ){
            return result;
        }
        User user = GsonUtils.getInstances().fromJson(User.class,userObj.toString());
        if(user.getRoleId()==null){
            return result;
        }
        List<Menu> menus = menuService.getByRoleId(user.getRoleId());
        result.setData(menus);
        return result;
    }


}
