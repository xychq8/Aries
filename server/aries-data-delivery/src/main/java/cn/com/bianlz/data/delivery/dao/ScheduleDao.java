package cn.com.bianlz.data.delivery.dao;

import cn.com.bianlz.data.delivery.api.vo.Schedule;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bianlanzhou on 17/10/17.
 * Description
 */
@Repository
public interface ScheduleDao {
    List<Schedule> get(Schedule schedule);
}
