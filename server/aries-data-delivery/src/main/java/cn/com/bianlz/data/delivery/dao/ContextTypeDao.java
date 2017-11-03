package cn.com.bianlz.data.delivery.dao;

import cn.com.bianlz.data.delivery.api.vo.ContextType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bianlanzhou on 17/11/3.
 * Description
 */
@Repository
public interface ContextTypeDao {
    List<ContextType> getByPositionId(@Param("dateStamp")String dateStamp,@Param("positionId")Long positionId,@Param("orderType")Integer orderType);
}
