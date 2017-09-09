package cn.com.bianlz.web.controller.login;

import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.web.client.LoginServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by bianlanzhou on 17/9/8.
 * Description
 */
@RestController("/auth")
public class LoginController {
    @Autowired
    private LoginServiceClient loginServiceClient;
    @PostMapping(value="/login")
    public Result login(@RequestBody Map<String,String> param){
        return loginServiceClient.login(param);
    }
}
