package cn.com.bianlz.data.delivery.dao;

import cn.com.bianlz.data.delivery.api.vo.Consume;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bianlanzhou on 17/10/20.
 * Description
 */
@Repository
public interface ConsumeDao {
    List<Consume> get(Consume consume);
}
