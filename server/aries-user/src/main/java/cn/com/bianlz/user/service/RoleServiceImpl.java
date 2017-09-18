package cn.com.bianlz.user.service;

import cn.com.bianlz.user.api.user.Role;
import cn.com.bianlz.user.mapper.RoleMapper;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by bianlanzhou on 17/9/4.
 * Description
 */
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Set<Long> getSubRoleId(Long roleId) {
        Set<Long> roleList = roleMapper.getSubRoleId(roleId);
        Set<Long> set = new HashSet<Long>();
        set.addAll(roleList);
        Set<Long> temp = new HashSet<Long>();
        while((temp=getSubRoleId(roleList,set)).size()>0){
            set.addAll(temp);
        }
        return set;
    }

    @Override
    public List<Role> getSubRole(Long id) {
        Set<Long> roleIds = getSubRoleId(id);
        List<Role> roles = new ArrayList<Role>();
        for(Long roleId : roleIds){
            roles.addAll(roleMapper.getRole(roleId));
        }
        return roles;
    }

    private Set<Long> getSubRoleId(Set<Long> roleSet,Set<Long> totalRoleList){
        Set<Long> set = new HashSet<Long>();
        for(Long id:roleSet){
            Set<Long> s = roleMapper.getSubRoleId(id);
            set.addAll(s);
        }
        totalRoleList.addAll(set);
        return set;
    }
}
