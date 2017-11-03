package cn.com.bianlz.service;

import cn.com.bianlz.common.utils.DateUtils;
import cn.com.bianlz.dao.ScheduleDao;
import cn.com.bianlz.dao.SchedulePositionDao;
import cn.com.bianlz.vo.Schedule;
import cn.com.bianlz.vo.SchedulePosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by bianlanzhou on 17/10/13.
 * Description
 */
@Service
public class ScheduleServiceImpl implements ScheduleService{
    @Autowired
    private ScheduleDao scheduleDao;
    @Autowired
    private SchedulePositionDao schedulePositionDao;
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


    @Override
    @Transactional
    public void saveSchedulePosition(String date,Map<String,Set<Long>> positionContext){
        schedulePositionDao.deleteByDay(date);
        for(Map.Entry<String,Set<Long>> entry:positionContext.entrySet()){
            String positionId = entry.getKey();
            Set<Long> uuids = entry.getValue();
            for(Long uuid:uuids){
                SchedulePosition schedulePosition = new SchedulePosition();
                schedulePosition.setDateStamp(date);
                schedulePosition.setUuid(uuid);
                schedulePosition.setPositionId(Long.valueOf(positionId));
                schedulePositionDao.insert(schedulePosition);
            }
        }
    }

}
