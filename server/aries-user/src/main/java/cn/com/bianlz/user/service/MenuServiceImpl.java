package cn.com.bianlz.user.service;

import cn.com.bianlz.user.api.menu.Menu;
import cn.com.bianlz.user.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
        List<Menu> list = menuMapper.getMenuByRoleId(roleId,1);
        for(Menu menu : list){
            List<Menu> subMenus = menuMapper.getSubMenu(menu.getId(),roleId,2);
            menu.setSubMenu(subMenus);
        }
        return list;
    }

    @Override
    public Map<String, Object> getUserMenu(Long rid, Long uRid) {
        Set<Long> checkSet = new HashSet<Long>();
        Map<String,Object> data = new HashMap<String, Object>();
        List<Menu> menuList = getByRoleId(rid);
        List<Menu> umList = menuMapper.getMenuByRoleId(uRid,2);
        for(Menu menu:umList){
            checkSet.add(menu.getId());
        }
        data.put("menus",menuList);
        data.put("check",checkSet);
        return data;
    }

    @Override
    public Integer saveMenu(Long rid,List<Long> mids) {
        Integer counter = 0;
        for(Long mid:mids){
            counter+=menuMapper.updateMenuStatus(rid,mid);
        }
        return counter;
    }


}
