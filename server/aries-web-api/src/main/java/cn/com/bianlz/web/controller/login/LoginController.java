package cn.com.bianlz.web.controller.login;

import cn.com.bianlz.common.utils.MD5Utils;
import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.user.api.protocol.UserProtocolCode;
import cn.com.bianlz.web.client.UserServiceClient;
import cn.com.bianlz.web.common.ResultHelper;
import cn.com.bianlz.web.common.WebApiProtocolCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by bianlanzhou on 17/9/8.
 * Description
 */
@RestController
public class LoginController {
    @Autowired
    private UserServiceClient userServiceClient;
    @PostMapping(value="/login")
    public Result login(@RequestBody Map<String,String> param){
        Result userResult = null;
        try {
            userResult = userServiceClient.login(param);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ResultHelper.getUserResult(userResult);
    }


}
