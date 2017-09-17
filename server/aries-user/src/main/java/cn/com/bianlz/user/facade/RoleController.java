package cn.com.bianlz.user.facade;

import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.user.api.user.Role;
import cn.com.bianlz.user.api.user.User;
import cn.com.bianlz.user.common.UserProtocolCode;
import cn.com.bianlz.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    private RoleService roleService;
    @GetMapping("/sub")
    public Result getSubRole(@RequestBody Long id){
        Result result = new Result();
        result.setCode(UserProtocolCode.SUCCESS.getCode());
        result.setMessage(UserProtocolCode.SUCCESS.getMessage());
        result.setData(roleService.getSubRole(id));
        return result;
    }
}
