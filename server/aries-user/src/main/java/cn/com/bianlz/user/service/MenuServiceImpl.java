package cn.com.bianlz.user.service;

import cn.com.bianlz.common.enums.Status;
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
    public Integer saveMenu(Long rid,List<Object> mids) {
        Integer counter = 0;
        String inCase="",notInCase="";
        for(Object obj:mids){
            inCase = inCase+","+obj;
        }
        notInCase = inCase = inCase.replaceFirst(",","");
        counter+=menuMapper.updateMenuStatus(rid,inCase,null, Status.VALID.getCode());
        counter+=menuMapper.updateMenuStatus(rid,null,notInCase,Status.VALID.getCode());
        return counter;
    }


}
