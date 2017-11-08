package cn.com.bianlz.dao;

import cn.com.bianlz.data.delivery.api.vo.ContextAge;
import cn.com.bianlz.data.delivery.api.vo.ContextArea;
import org.springframework.stereotype.Repository;

/**
 * Created by bianlanzhou on 17/11/8.
 * Description
 */
@Repository
public interface ContextAgeDao {
    int insert(ContextAge contextAge);
    int deleteByDay(String day);
}
