package cn.com.bianlz.data.delivery.service;

import cn.com.bianlz.data.delivery.api.vo.Schedule;
import cn.com.bianlz.data.delivery.dao.ScheduleDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bianlanzhou on 17/10/17.
 * Description
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleDao scheduleDao;
    @Override
    public List<Schedule> get(Schedule schedule) {
        return scheduleDao.get(schedule);
    }
}
