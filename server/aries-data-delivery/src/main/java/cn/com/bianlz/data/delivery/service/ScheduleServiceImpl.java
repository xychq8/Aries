package cn.com.bianlz.data.delivery.service;

import cn.com.bianlz.data.delivery.api.vo.Schedule;
import cn.com.bianlz.data.delivery.api.vo.ScheduleWarning;
import cn.com.bianlz.data.delivery.dao.ScheduleDao;
import cn.com.bianlz.data.delivery.dao.ScheduleWarningDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bianlanzhou on 17/10/17.
 * Description
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleDao scheduleDao;
    @Autowired
    private ScheduleWarningDao scheduleWarningDao;
    @Override
    public List<Schedule> get(Schedule schedule) {
        return scheduleDao.get(schedule);
    }

    @Override
    public List<ScheduleWarning> getByDay(String dateStamp) {
        return scheduleWarningDao.getByDay(dateStamp);
    }

    public Map<String,Integer> getScheduleIndex(String dateStamp){
        Map<String,Integer> indexMap = new HashMap<String, Integer>();
        int warnIndex = scheduleWarningDao.getWarningIndex(dateStamp);
        int posIndex = scheduleWarningDao.getWarningPositionIndex(dateStamp);
        indexMap.put("warnIndex",warnIndex);
        indexMap.put("posIndex",posIndex);
        return indexMap;
    }
}
