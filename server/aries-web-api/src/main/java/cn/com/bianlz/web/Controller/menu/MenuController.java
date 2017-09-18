package cn.com.bianlz.web.controller.menu;

import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.web.client.UserServiceClient;
import cn.com.bianlz.web.common.Authorizition;
import cn.com.bianlz.web.common.WebApiProtocolCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
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
        Result result = new Result();
        result.setCode(WebApiProtocolCode.SUCCESS.getCode());
        result.setMessage(WebApiProtocolCode.SUCCESS.getMessage());
        User user = (User)request.getSession().getAttribute("user");
        if(user==null||user.getRoleId()==null){
            return result;
        }
        result.setData(userServiceClient.getMenu(user.getRoleId()).getData());
        return result;
    }


    @GetMapping("/menu/ur/{uRid}")
    public Result<Map<String,Object>> getUserMenu(@PathVariable("uRid")Long uRid,HttpServletRequest request){
        Result<Map<String,Object>> result = new Result();
        result.setCode(WebApiProtocolCode.SUCCESS.getCode());
        result.setMessage(WebApiProtocolCode.SUCCESS.getMessage());
        User user = (User)request.getSession().getAttribute("user");
        if(user==null||user.getRoleId()==null){
            return result;
        }
        result.setData(userServiceClient.getUserMenu(user.getRoleId(),uRid).getData());
        return result;
    }
}
