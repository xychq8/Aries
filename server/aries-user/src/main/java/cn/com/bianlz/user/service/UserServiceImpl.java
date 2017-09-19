package cn.com.bianlz.user.service;

import cn.com.bianlz.user.api.user.User;
import cn.com.bianlz.common.utils.MD5Utils;
import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.user.api.protocol.UserProtocolCode;
import cn.com.bianlz.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by bianlanzhou on 17/9/1.
 * Description
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    public List<User> getUser(User user){
        return userMapper.get(user);
    }

    @Override
    public boolean checkUser(Result<Map<String, Object>> result, User user) {
        if(user.getUsername() == null){
            result.setCode(UserProtocolCode.LOGIN_USER_NOT_FOUND.getCode());
            result.setMessage(UserProtocolCode.LOGIN_USER_NOT_FOUND.getMessage());
            return false;
        }
        if(user.getPassword() == null){
            result.setCode(UserProtocolCode.LOGIN_PASSWORD_ERROR.getCode());
            result.setMessage(UserProtocolCode.LOGIN_PASSWORD_ERROR.getMessage());
            return false;
        }
        String password = user.getPassword();
        user.setPassword(null);
        List<User> list = getUser(user);
        if(list.size()<=0){
            result.setCode(UserProtocolCode.LOGIN_USER_NOT_FOUND.getCode());
            result.setMessage(UserProtocolCode.LOGIN_USER_NOT_FOUND.getMessage());
            return false;
        }
        user.setRoleId(list.get(0).getRoleId());
        try {
            password = MD5Utils.getMD5(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(!password.equals(list.get(0).getPassword())){
            result.setCode(UserProtocolCode.LOGIN_PASSWORD_ERROR.getCode());
            result.setMessage(UserProtocolCode.LOGIN_PASSWORD_ERROR.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<User> getUserByRoleIds(Set<Long> roleIds) {
        String roleIdsStr = "-100";
        if(roleIds!=null&&roleIds.size()>0){
            for(Long roleId:roleIds){
                roleIdsStr = roleIdsStr + "," + roleId;
            }
        }
        return userMapper.getByRoleIds(roleIdsStr);
    }

    @Override
    public Integer updateUser(User user) {
        if(user.getId()==null||user.getId()<=0){
            return 0;
        }
        if(user.getPassword()!=null){
            try {
                user.setPassword(MD5Utils.getMD5(user.getPassword()));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return userMapper.updateUser(user);
    }


}
