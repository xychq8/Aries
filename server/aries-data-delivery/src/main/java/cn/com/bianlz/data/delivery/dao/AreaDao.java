package cn.com.bianlz.data.delivery.dao;

import cn.com.bianlz.data.delivery.api.vo.Area;
import cn.com.bianlz.data.delivery.api.vo.Interest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bianlanzhou on 17/11/9.
 * Description
 */
@Repository
public interface AreaDao {
    List<Area> getAreaById(Integer code);
    List<Area> getAreaByIds(@Param("ids")List ids);
}
