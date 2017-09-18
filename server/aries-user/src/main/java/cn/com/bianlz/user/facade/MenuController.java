package cn.com.bianlz.user.facade;

import cn.com.bianlz.common.utils.GsonUtils;
import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.user.api.menu.Menu;
import cn.com.bianlz.user.api.user.User;
import cn.com.bianlz.user.common.RedisKeys;
import cn.com.bianlz.user.common.UserProtocolCode;
import cn.com.bianlz.user.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bianlanzhou on 17/9/10.
 * Description
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private StringRedisTemplate template;
    @Autowired
    private MenuService menuService;
    @GetMapping("/rid/{rid}")
    public Result getMenu(@PathVariable("rid") Long rid){
        Result<List<Menu>> result = new Result<List<Menu>>();
        result.setCode(UserProtocolCode.SUCCESS.getCode());
        result.setMessage(UserProtocolCode.SUCCESS.getMessage());
        if(rid==null){
            return result;
        }
        List<Menu> menus = menuService.getByRoleId(rid);
        result.setData(menus);
        return result;
    }
    @GetMapping("/get")
    public Result<Map<String, Object>> getUserMenu(@RequestParam("rid")Long rid,@RequestParam("uRid")Long uRid){
        Result<Map<String, Object>> result = new Result<Map<String, Object>>();
        result.setCode(UserProtocolCode.SUCCESS.getCode());
        result.setMessage(UserProtocolCode.SUCCESS.getMessage());
        result.setData(menuService.getUserMenu(rid, uRid));
        return result;
    }
    @PostMapping("/menuRole")
    public Result<Integer> saveMenuRole(@RequestBody Map<String,Object> param){
        Result<Integer> result = new Result<Integer>();
        result.setCode(UserProtocolCode.SUCCESS.getCode());
        result.setMessage(UserProtocolCode.SUCCESS.getMessage());
        Long id = null;
        if(param.get("id")!=null){
            try {
                id = Long.valueOf(param.get("id").toString());
            }catch (Exception ex){}
        }
        List<String> menuIds = (List)param.get("menus");
        if(id==null||menuIds==null){
            result.setCode(UserProtocolCode.PARAM_ERROR.getCode());
            result.setMessage(UserProtocolCode.PARAM_ERROR.getMessage());
            return result;
        }
        Integer ref = menuService.saveMenu(id, menuIds);
        result.setData(ref);
        return result;
    }


}
