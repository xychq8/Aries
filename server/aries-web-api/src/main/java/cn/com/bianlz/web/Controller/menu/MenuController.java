package cn.com.bianlz.web.controller.menu;

import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.web.client.MenuServiceClient;
import cn.com.bianlz.web.common.Authorizition;
import cn.com.bianlz.web.common.WebApiProtocolCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import cn.com.bianlz.user.api.user.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by bianlanzhou on 17/9/10.
 * Description
 */
@RestController
@Authorizition
public class MenuController {

    @Autowired
    private MenuServiceClient menuServiceClient;
    @GetMapping("/menu")
    public Result getMenu(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        if(user==null||user.getRoleId()==null){
            Result result = new Result();
            result.setCode(WebApiProtocolCode.SUCCESS.getCode());
            result.setMessage(WebApiProtocolCode.SUCCESS.getMessage());
            return result;
        }
        return menuServiceClient.getMenu(user.getRoleId());
    }
}
