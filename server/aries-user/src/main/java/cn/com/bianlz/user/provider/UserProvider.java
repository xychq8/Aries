package cn.com.bianlz.user.provider;

import cn.com.bianlz.user.api.user.User;
import cn.com.bianlz.common.enums.Status;

import java.util.Set;

/**
 * Created by bianlanzhou on 17/9/1.
 * Description
 */
public class UserProvider {
    public String get(User user){
        StringBuilder sb = new StringBuilder();
        sb.append(" select * from user ");
        sb.append(" where 1=1 ");
        if(user!=null){
            if(user.getId()!=null){
                sb.append(" and id = ").append(user.getId());
            }
            if(user.getUsername()!=null){
                sb.append(" and username ='").append(user.getUsername()).append("'");
            }
            if(user.getPassword()!=null){
                sb.append(" and password = '").append(user.getPassword()).append("'");
            }
            if(user.getStatus()!=null){
                sb.append(" and status = ").append(user.getStatus());
            }else{
                sb.append(" and status = ").append(Status.VALID.getCode());
            }
        }
        return sb.toString();
    }
    public String getByRoleIds(String roleIds){

        if(roleIds==null||"".equals(roleIds)){
            roleIds = "-100";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("select * from user ");
        sb.append(" where role_id in (");
        sb.append(roleIds).append(")");
        sb.append(" and status = ").append(Status.VALID.getCode());
        return sb.toString();
    }
}
