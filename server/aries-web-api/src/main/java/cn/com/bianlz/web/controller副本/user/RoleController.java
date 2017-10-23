package cn.com.bianlz.web.controller.user;

import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.user.api.user.Role;
import cn.com.bianlz.user.api.user.User;
import cn.com.bianlz.web.client.UserServiceClient;
import cn.com.bianlz.web.common.Authorizition;
import cn.com.bianlz.web.common.ResultHelper;
import cn.com.bianlz.web.common.WebApiProtocolCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by bianlanzhou on 17/9/17.
 * Description
 */
@RestController
@RequestMapping("/role")
@Authorizition
public class RoleController {
    @Autowired
    private UserServiceClient userServiceClient;
    @GetMapping("/sub")
    public Result getRoles(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        Long roleId = -100l;
        if(user!=null&&user.getRoleId()!=null){
            roleId = user.getRoleId();
        }
        Result<List<Role>> userResult = new Result<List<Role>>();
        userResult = userServiceClient.getSubRole(roleId);
        return ResultHelper.getUserResult(userResult);
    }
}
