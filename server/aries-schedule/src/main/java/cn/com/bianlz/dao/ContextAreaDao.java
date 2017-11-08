package cn.com.bianlz.dao;

import cn.com.bianlz.data.delivery.api.vo.ContextArea;
import cn.com.bianlz.data.delivery.api.vo.ContextSex;
import org.springframework.stereotype.Repository;

/**
 * Created by bianlanzhou on 17/11/8.
 * Description
 */
@Repository
public interface ContextAreaDao {
    int insert(ContextArea contextArea);
    int deleteByDay(String day);
}
