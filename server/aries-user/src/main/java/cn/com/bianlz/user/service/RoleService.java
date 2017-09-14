package cn.com.bianlz.user.service;

import java.util.List;
import java.util.Set;

/**
 * Created by bianlanzhou on 17/9/4.
 * Description
 */
public interface RoleService {
    public Set<Long> getSubRoleId(Long roleId);
}
