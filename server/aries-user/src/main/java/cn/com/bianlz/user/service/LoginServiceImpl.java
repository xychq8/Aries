package cn.com.bianlz.user.service;

import cn.com.bianlz.common.utils.CodecUtils;
import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.user.api.menu.Menu;
import cn.com.bianlz.user.api.user.User;
import cn.com.bianlz.user.common.RedisKeys;
import cn.com.bianlz.user.common.UserProtocolCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by bianlanzhou on 17/9/1.
 * Description
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private StringRedisTemplate template;
    @Override
    public Result login(String username, String password) {
        Result<Map<String,Object>> result = new Result<Map<String,Object>>();
        Map<String,Object> data = new HashMap<String, Object>(3);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        //check user
        if(!userService.checkUser(result,user)){
            return result;
        }
        // get menu
        List<Menu> menus = menuService.getByRoleId(user.getRoleId());
        //gen token
        String token = CodecUtils.base64(username);
        //timeout 30min
        template.opsForValue().set(RedisKeys.TOKEN,token,30, TimeUnit.SECONDS);
        data.put("token",token);
        data.put("username",username);
        data.put("menu",menus);
        result.setCode(UserProtocolCode.SUCCESS.getCode());
        result.setMessage(UserProtocolCode.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }




}
