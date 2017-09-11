package cn.com.bianlz.web.controller.menu;

import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.web.client.MenuServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by bianlanzhou on 17/9/10.
 * Description
 */
@RestController
public class MenuController {

    @Autowired
    private MenuServiceClient menuServiceClient;
    @GetMapping("/menu")
    public Result getMenu(HttpServletRequest request){
        String token = request.getHeader("token");
        return menuServiceClient.getMenu(token);
    }
}
