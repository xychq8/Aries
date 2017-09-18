package cn.com.bianlz.user.mapper;

import cn.com.bianlz.user.api.menu.Menu;
import cn.com.bianlz.user.provider.MenuProvider;
import cn.com.bianlz.user.provider.RoleProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
 * Created by bianlanzhou on 17/9/1.
 * Description
 */
public interface MenuMapper {
    @SelectProvider(type = MenuProvider.class,method = "getMenuIdByRoleId")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "code",column = "code"),
            @Result(property = "parentId",column = "parent_id"),
            @Result(property = "path",column = "path"),
            @Result(property = "level",column = "level"),
            @Result(property = "status",column = "status"),
            @Result(property = "createDate",column = "create_date")
    })
    List<Menu> getMenuByRoleId(Long roleId,Integer level);

    @SelectProvider(type = MenuProvider.class,method = "getSubMenu")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "code",column = "code"),
            @Result(property = "parentId",column = "parent_id"),
            @Result(property = "path",column = "path"),
            @Result(property = "level",column = "level"),
            @Result(property = "status",column = "status"),
            @Result(property = "createDate",column = "create_date")
    })
    List<Menu> getSubMenu(Long parentId,Long roleId,Integer level);

    @UpdateProvider(type = MenuProvider.class,method = "updateMenuStatus")
    Integer updateMenuStatus(Long rid,Long id);
}
