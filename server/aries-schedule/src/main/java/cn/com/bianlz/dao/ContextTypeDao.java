package cn.com.bianlz.dao;

import cn.com.bianlz.data.delivery.api.vo.ContextType;
import org.springframework.stereotype.Repository;

/**
 * Created by bianlanzhou on 17/11/3.
 * Description
 */
@Repository
public interface ContextTypeDao {
    int insert(ContextType contextType);
    int deleteByDay(String day);
}
