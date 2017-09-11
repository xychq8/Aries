package cn.com.bianlz.user.facade;

import cn.com.bianlz.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.com.bianlz.common.vo.Result;

import java.util.Map;

/**
 * Created by bianlanzhou on 17/9/1.
 * Description
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private LoginService loginService;
    @PostMapping(value="/login")
    public Result login(@RequestBody Map<String,String> param){
        return loginService.login(param.get("username"),param.get("password"));
    }
}
