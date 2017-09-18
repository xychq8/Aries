package cn.com.bianlz.user.facade;

import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.user.api.user.User;
import cn.com.bianlz.user.common.UserProtocolCode;
import cn.com.bianlz.user.service.RoleService;
import cn.com.bianlz.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * Created by bianlanzhou on 17/9/14.
 * Description
 */
@RestController
public class UserController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @GetMapping("/list/roleId/{roleId}")
    public Result<List<User>> getUserByRoleId(@PathVariable("roleId") Long roleId){
        Result<List<User>> result = new Result<List<User>>();
        result.setCode(UserProtocolCode.SUCCESS.getCode());
        result.setMessage(UserProtocolCode.SUCCESS.getMessage());
        Set<Long> roleIds = roleService.getSubRoleId(roleId);
        if(roleIds!=null&&roleIds.size()>0){
            List<User> list = userService.getUserByRoleIds(roleIds);
            result.setData(list);
        }
        return result;
    }

    @PostMapping("/update")
    public Result<Integer> updateUser(@RequestBody User user){
        Result<Integer> result = new Result();
        result.setCode(UserProtocolCode.SUCCESS.getCode());
        result.setMessage(UserProtocolCode.SUCCESS.getMessage());
        Integer ref = userService.updateUser(user);
        if(ref<=0){
            result.setCode(UserProtocolCode.UPDATE_FAIL.getCode());
            result.setMessage(UserProtocolCode.UPDATE_FAIL.getMessage());
        }
        result.setData(ref);
        return result;
    }
}
