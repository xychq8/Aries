package cn.com.bianlz.service;

import cn.com.bianlz.common.utils.DateUtils;
import cn.com.bianlz.dao.ScheduleDao;
import cn.com.bianlz.vo.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by bianlanzhou on 17/10/13.
 * Description
 */
@Service
public class ScheduleServiceImpl implements ScheduleService{
    @Autowired
    private ScheduleDao scheduleDao;
    @Override
    @Transactional
    public void saveSchedule(Collection<Schedule> collection)throws Exception{
        String date = DateUtils.getYYMMDD(new Date());
        int i = 0;
        scheduleDao.deleteByDatestamp(date);
        if(collection!=null){
            for(Schedule schedule:collection){
                schedule.setDateStamp(date);
                if(schedule!=null){
                    schedule.setId(Long.valueOf(date + schedule.getId()));
                    if(schedule.getHoursList()!=null){
                        schedule.setHours(Arrays.toString(schedule.getHoursList().toArray()));
                    }else{
                        schedule.setHours("[]");
                    }
                    scheduleDao.insert(schedule);
                }
            }
        }
    }

    @Override
    public List<Schedule> getScheduleByDay(String day) {
        return scheduleDao.selectByDay(day);
    }

}
