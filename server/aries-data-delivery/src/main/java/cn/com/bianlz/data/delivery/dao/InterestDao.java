package cn.com.bianlz.data.delivery.dao;

import cn.com.bianlz.data.delivery.api.vo.Interest;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bianlanzhou on 17/11/9.
 * Description
 */
@Repository
public interface InterestDao {
    List<Interest> getInterestByCode(String code);
}
