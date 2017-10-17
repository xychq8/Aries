package cn.com.bianlz.data.delivery.service;

import cn.com.bianlz.data.delivery.api.vo.Schedule;

import java.util.List;

/**
 * Created by bianlanzhou on 17/10/17.
 * Description
 */
public interface ScheduleService {
    public List<Schedule> get(Schedule schedule);
}
