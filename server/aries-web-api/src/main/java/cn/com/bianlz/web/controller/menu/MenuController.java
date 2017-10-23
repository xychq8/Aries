package cn.com.bianlz.web.controller.menu;

import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.web.client.UserServiceClient;
import cn.com.bianlz.web.common.Authorizition;
import cn.com.bianlz.web.common.ResultHelper;
import cn.com.bianlz.web.common.WebApiProtocolCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.com.bianlz.user.api.user.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by bianlanzhou on 17/9/10.
 * Description
 */
@RestController
@Authorizition
public class MenuController {
    @Autowired
    private UserServiceClient userServiceClient;
    @GetMapping("/menu")
    public Result getMenu(HttpServletRequest request){
        Result userResult = new Result();
        User user = (User)request.getSession().getAttribute("user");
        Long roleId = -100l;
        if(user!=null&&user.getRoleId()!=null){
            roleId = user.getRoleId();
        }
        try {
            userResult = userServiceClient.getMenu(roleId);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ResultHelper.getUserResult(userResult);
    }


    @GetMapping("/menu/ur/{uRid}")
    public Result<Map<String,Object>> getUserMenu(@PathVariable("uRid")Long uRid,HttpServletRequest request){
        Result<Map<String,Object>> userResult = new Result();
        User user = (User)request.getSession().getAttribute("user");
        Long roleId = -100l;
        if(user!=null&&user.getRoleId()!=null){
            roleId = user.getRoleId();
        }
        try {
            userResult = userServiceClient.getUserMenu(roleId, uRid);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ResultHelper.getUserResult(userResult);
    }

    @PostMapping("/menu/menuRole")
    public Result<Integer> saveMenuRole(HttpServletRequest request,@RequestBody Map<String,Object> param){
        Result<Integer> userResult = new Result();
        try {
            userResult = userServiceClient.saveMenuRole(param);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ResultHelper.getUserResult(userResult);
    }
}
