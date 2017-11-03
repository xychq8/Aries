package cn.com.bianlz.data.delivery.dao;

import cn.com.bianlz.data.delivery.api.vo.Position;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bianlanzhou on 17/11/1.
 * Description
 */
@Repository
public interface PositionDao {
    List<Position> getByPositionId(Long positionId);
    List<Position> getPositionByIds(List<Long> ids);
}
