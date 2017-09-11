package cn.com.bianlz.user.service;

import cn.com.bianlz.user.api.menu.Menu;
import cn.com.bianlz.user.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bianlanzhou on 17/9/4.
 * Description
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> getByRoleId(Long roleId) {
        List<Menu> list = menuMapper.getMenuByRoleId(roleId);
        for(Menu menu : list){
            List<Menu> subMenus = menuMapper.getSubMenu(menu.getId(),2);
            menu.setSubMenu(subMenus);
        }
        return list;
    }
}
