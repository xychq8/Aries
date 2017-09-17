package cn.com.bianlz.web.controller.login;

import cn.com.bianlz.common.utils.MD5Utils;
import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.web.client.UserServiceClient;
import cn.com.bianlz.web.common.WebApiProtocolCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * Created by bianlanzhou on 17/9/8.
 * Description
 */
@RestController("/auth")
public class LoginController {
    @Autowired
    private UserServiceClient userServiceClient;
    @PostMapping(value="/login")
    public Result login(@RequestBody Map<String,String> param){
        Result result = new Result();
        result.setCode(WebApiProtocolCode.SUCCESS.getCode());
        result.setMessage(WebApiProtocolCode.SUCCESS.getMessage());
        result.setData(userServiceClient.login(param).getData());
        return result;
    }
}
