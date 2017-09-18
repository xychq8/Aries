package cn.com.bianlz.user.provider;

import cn.com.bianlz.common.enums.Status;

/**
 * Created by bianlanzhou on 17/9/1.
 * Description
 */
public class MenuProvider {
    public String getMenuIdByRoleId(Long id,Integer level){
        StringBuffer sb = new StringBuffer();
        sb.append(" select b.* from menu_role a ,menu b ");
        sb.append(" where a.menu_id = b.id ");
        if(id!=null){
            sb.append(" and a.role_id = ").append(id);
        }else{
            sb.append(" and a.role_id = -100 ");
        }
        if(level!=null&&level>0){
            sb.append(" and b.level=").append(level);
        }
        sb.append(" and b.status = a.status = ").append(Status.VALID.getCode());
        return sb.toString();
    }

    public String getSubMenu(Long parentId,Integer level){
        StringBuffer sb = new StringBuffer();
        sb.append(" select * from menu where ");
        sb.append(" parent_id = ").append(parentId);
        sb.append(" and level = ").append(level);
        sb.append(" and status = ").append(Status.VALID.getCode());
        return sb.toString();
    }
}
