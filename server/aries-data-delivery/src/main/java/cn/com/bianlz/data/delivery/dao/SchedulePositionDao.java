package cn.com.bianlz.data.delivery.dao;


import cn.com.bianlz.data.delivery.api.vo.SchedulePosition;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bianlanzhou on 17/11/1.
 * Description
 */
@Repository
public interface SchedulePositionDao {
    int deleteByPrimaryKey(Integer id);

    int deleteByDay(String datestamp);

    int insert(SchedulePosition record);

    int insertSelective(SchedulePosition record);

    SchedulePosition selectByPrimaryKey(Integer id);

    List<SchedulePosition> select(SchedulePosition schedulePosition);

    int updateByPrimaryKeySelective(SchedulePosition record);

    int updateByPrimaryKey(SchedulePosition record);
}

