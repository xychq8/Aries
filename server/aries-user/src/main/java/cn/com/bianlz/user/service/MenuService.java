package cn.com.bianlz.user.service;

import cn.com.bianlz.user.api.menu.Menu;

import java.util.List;

/**
 * Created by bianlanzhou on 17/9/4.
 * Description
 */
public interface MenuService {
    List<Menu> getByRoleId(Long roleId);
}
