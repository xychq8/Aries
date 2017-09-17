package cn.com.bianlz.web.controller.user;

import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.user.api.user.Role;
import cn.com.bianlz.user.api.user.User;
import cn.com.bianlz.web.client.UserServiceClient;
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
public class RoleController {
    @Autowired
    private UserServiceClient userServiceClient;
    @GetMapping("/sub")
    public Result getRoles(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        Result<List<Role>> result = new Result<List<Role>>();
        result.setCode(WebApiProtocolCode.SUCCESS.getCode());
        result.setMessage(WebApiProtocolCode.SUCCESS.getMessage());
        result.setData(userServiceClient.getSubRole(user.getRoleId()).getData());
        return result;
    }
}
