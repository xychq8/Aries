package cn.com.bianlz.user.provider;

import cn.com.bianlz.common.enums.Status;

/**
 * Created by bianlanzhou on 17/9/1.
 * Description
 */
public class MenuProvider {
    public String getMenuIdByRoleId(Long id,Integer level,Long parentId){
        StringBuffer sb = new StringBuffer();
        sb.append(" select b.* from menu_role a ,menu b ");
        sb.append(" where a.menu_id = b.id ");
        if(id!=null){
            sb.append(" and a.id = ").append(id);
        }else{
            sb.append(" and a.id = -1 ");
        }
        if(parentId!=null){
            sb.append(" and parent_id = ").append(parentId);
        }
        sb.append(" b.level = ").append(level);
        sb.append(" and status = ").append(Status.VALID.getCode());
        return sb.toString();
    }
}
