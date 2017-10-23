package cn.com.bianlz.web.controller.user;

import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.user.api.user.User;
import cn.com.bianlz.web.client.UserServiceClient;
import cn.com.bianlz.web.common.Authorizition;
import cn.com.bianlz.web.common.ResultHelper;
import cn.com.bianlz.web.common.WebApiProtocolCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by bianlanzhou on 17/9/10.
 * Description
 */
@RestController
@Authorizition
public class UserController {
    @Autowired
    private UserServiceClient userServiceClient;
    @GetMapping("/user")
    public Result getMenu(HttpServletRequest request){
        Result userResult = new Result();
        User user = (User)request.getSession().getAttribute("user");
        Long roleId = -100l;
        if(user!=null&&user.getRoleId()!=null){
            roleId = user.getRoleId();
        }
        userResult = userServiceClient.getUserByRoleId(roleId);
        return ResultHelper.getUserResult(userResult);
    }

    @PostMapping("/user/update")
    public Result update(@RequestBody User user){
        Result userResult = new Result();
        userResult = userServiceClient.updateUser(user);
        return ResultHelper.getUserResult(userResult);
    }
}
