package cn.com.bianlz.user.mapper;

import cn.com.bianlz.user.api.menu.Menu;
import cn.com.bianlz.user.provider.RoleProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Set;

/**
 * Created by bianlanzhou on 17/9/4.
 * Description
 */
public interface RoleMapper {
    @SelectProvider(type = RoleProvider.class,method = "getSubRoleId")
    public Set<Long> getSubRoleId(Long roleId);
}
