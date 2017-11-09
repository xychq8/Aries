package cn.com.bianlz.data.delivery.dao;

import cn.com.bianlz.data.delivery.api.vo.ContextArea;
import cn.com.bianlz.data.delivery.api.vo.ContextNetwork;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bianlanzhou on 17/11/9.
 * Description
 */
@Repository
public interface ContextAreaDao {
    List<ContextArea> getByUuid(@Param("uuid") Long uuid, @Param("date") String date);
}
