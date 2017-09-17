package cn.com.bianlz.user.facade;

import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.user.api.user.Role;
import cn.com.bianlz.user.api.user.User;
import cn.com.bianlz.user.common.UserProtocolCode;
import cn.com.bianlz.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/sub/{roleId}")
    public Result getSubRole(@PathVariable("roleId") Long id){
        Result result = new Result();
        result.setCode(UserProtocolCode.SUCCESS.getCode());
        result.setMessage(UserProtocolCode.SUCCESS.getMessage());
        result.setData(roleService.getSubRole(id));
        return result;
    }
}
