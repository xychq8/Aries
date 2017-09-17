package cn.com.bianlz.user.provider;

import cn.com.bianlz.common.Constants;
import cn.com.bianlz.common.enums.Status;

/**
 * Created by bianlanzhou on 17/9/4.
 * Description
 */
public class RoleProvider {
    public String getSubRoleId(Long roleId){
        StringBuilder sb = new StringBuilder();
        sb.append(" select id from role ");
        sb.append(" where parent_id =").append(roleId);
        sb.append(" and status = ").append(Status.VALID.getCode());
        return sb.toString();
    }

    public String getRole(Long roleId){
        StringBuilder sb = new StringBuilder();



        sb.append(" select id,name,parent_id,DATE_FORMAT(create_date,'%Y-%m-%d %H:%i:%S') as create_date,status from role ");
        sb.append(" where 1=1 ");
        if(roleId!=null&&roleId<=0){
            sb.append(" and id = ").append(roleId);
        }else{
            sb.append(" and id=-100 ");
        }
        return sb.toString();
    }
}
