package cn.com.bianlz.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PositionDao {
    List<Map<String,Object>> getPosition(Long positionId);
}
