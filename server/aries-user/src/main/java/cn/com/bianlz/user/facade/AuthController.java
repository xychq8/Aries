package cn.com.bianlz.user.facade;

import cn.com.bianlz.common.utils.GsonUtils;
import cn.com.bianlz.user.api.user.User;
import cn.com.bianlz.user.common.RedisKeys;
import cn.com.bianlz.user.api.protocol.UserProtocolCode;
import cn.com.bianlz.user.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import cn.com.bianlz.common.vo.Result;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by bianlanzhou on 17/9/1.
 * Description
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private StringRedisTemplate template;
    @Autowired
    private LoginService loginService;
    @PostMapping(value="/login")
    public Result login(@RequestBody Map<String,String> param){
        Result result = loginService.login(param.get("username"),param.get("password"));
        logger.debug("login result:"+(result==null?"null":GsonUtils.getInstances().toJson(result)));
        return result;
    }

    @GetMapping(value="/token/{token}")
    public Result<User> getUserByToken(@PathVariable("token") String token){
        Result result = new Result();
        result.setCode(UserProtocolCode.SUCCESS.getCode());
        result.setMessage(UserProtocolCode.SUCCESS.getMessage());
        Object userObj = template.opsForValue().get(RedisKeys.TOKEN+token);
        if(userObj == null ){
            return result;
        }
        template.opsForValue().set(RedisKeys.TOKEN+token,userObj.toString(),30, TimeUnit.MINUTES);
        User user = GsonUtils.getInstances().fromJson(User.class,userObj.toString());
        result.setData(user);
        return result;
    }

    @PostMapping
    public Result changePassword(){
        Result result = new Result();
        result.setCode(UserProtocolCode.SUCCESS.getCode());
        result.setMessage(UserProtocolCode.SUCCESS.getMessage());
        return result;
    }

}
