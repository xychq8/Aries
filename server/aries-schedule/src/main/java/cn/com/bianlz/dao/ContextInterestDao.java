package cn.com.bianlz.dao;

import cn.com.bianlz.data.delivery.api.vo.ContextInterest;
import cn.com.bianlz.data.delivery.api.vo.ContextOs;
import org.springframework.stereotype.Repository;

/**
 * Created by bianlanzhou on 17/11/8.
 * Description
 */
@Repository
public interface ContextInterestDao {
    int insert(ContextInterest contextOs);
    int deleteByDay(String day);
}
