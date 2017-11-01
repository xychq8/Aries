package cn.com.bianlz.dao;

import cn.com.bianlz.vo.SchedulePosition;
import org.springframework.stereotype.Repository;

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

    int updateByPrimaryKeySelective(SchedulePosition record);

    int updateByPrimaryKey(SchedulePosition record);
}

