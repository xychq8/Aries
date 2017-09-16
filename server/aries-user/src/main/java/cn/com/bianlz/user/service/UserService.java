package cn.com.bianlz.user.service;

import cn.com.bianlz.user.api.user.User;
import cn.com.bianlz.common.vo.Result;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by bianlanzhou on 17/9/1.
 * Description
 */
public interface UserService {
    List<User> getUser(User user);
    boolean checkUser(Result<Map<String,Object>> result,User user);
    List<User> getUserByRoleIds(Set<Long> roleIds);
    public Integer updateUser(User user);
}
