package cn.com.bianlz.dao;

import cn.com.bianlz.vo.Consume;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bianlanzhou on 17/10/20.
 * Description
 */
@Repository
public interface ConsumeDao {
    List<Consume> selectByDay(String day);
    int insert(Consume consume);
    int deleteByDay(String day);
}
