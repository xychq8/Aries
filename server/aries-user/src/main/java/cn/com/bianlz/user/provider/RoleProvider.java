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
}
