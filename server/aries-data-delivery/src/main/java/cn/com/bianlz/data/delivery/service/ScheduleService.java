package cn.com.bianlz.data.delivery.service;

import cn.com.bianlz.data.delivery.api.vo.Schedule;
import cn.com.bianlz.data.delivery.api.vo.ScheduleWarning;

import java.util.List;
import java.util.Map;

/**
 * Created by bianlanzhou on 17/10/17.
 * Description
 */
public interface ScheduleService {
    List<Schedule> get(Schedule schedule);
    List<ScheduleWarning> getByDay(String dateStamp);
    Map<String,Integer> getScheduleIndex(String dateStamp);
}
