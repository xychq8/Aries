package cn.com.bianlz.data.delivery.dao;

import cn.com.bianlz.data.delivery.api.vo.ContextAge;
import cn.com.bianlz.data.delivery.api.vo.ContextArea;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bianlanzhou on 17/11/9.
 * Description
 */
@Repository
public interface ContextAgeDao {
    List<ContextAge> getByUuid(@Param("uuid") Long uuid, @Param("date") String date);
}
