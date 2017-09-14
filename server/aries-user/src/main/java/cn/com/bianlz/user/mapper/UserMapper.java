package cn.com.bianlz.user.mapper;

import cn.com.bianlz.user.api.user.User;
import cn.com.bianlz.user.provider.UserProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Set;

/**
 * Created by bianlanzhou on 17/9/1.
 * Description
 */
public interface UserMapper {
    @SelectProvider(type = UserProvider.class,method = "get")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "name",column = "name"),
            @Result(property = "password",column = "password"),
            @Result(property = "status",column = "status"),
            @Result(property = "createDate",column = "create_date"),
            @Result(property = "email",column = "email"),
            @Result(property = "phone",column = "phone"),
            @Result(property = "roleId",column = "role_id")
    })
    List<User> get(User user);

    @SelectProvider(type = UserProvider.class,method = "getByRoleIds")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "name",column = "name"),
            @Result(property = "status",column = "status"),
            @Result(property = "createDate",column = "create_date"),
            @Result(property = "email",column = "email"),
            @Result(property = "phone",column = "phone"),
            @Result(property = "roleId",column = "role_id")
    })
    List<User> getByRoleIds(String roleIds);


}
