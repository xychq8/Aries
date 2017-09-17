package cn.com.bianlz.user.service;

import cn.com.bianlz.user.api.user.Role;

import java.util.List;
import java.util.Set;

/**
 * Created by bianlanzhou on 17/9/4.
 * Description
 */
public interface RoleService {
    public Set<Long> getSubRoleId(Long roleId);

    public List<Role> getSubRole(Long id);


}
