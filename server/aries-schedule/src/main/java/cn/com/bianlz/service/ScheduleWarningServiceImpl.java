package cn.com.bianlz.service;

import cn.com.bianlz.common.utils.DateUtils;
import cn.com.bianlz.dao.PositionDao;
import cn.com.bianlz.dao.SchedulePositionDao;
import cn.com.bianlz.dao.ScheduleWarningDao;
import cn.com.bianlz.vo.Consume;
import cn.com.bianlz.vo.Schedule;
import cn.com.bianlz.vo.SchedulePosition;
import cn.com.bianlz.vo.ScheduleWarning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Component
public class ScheduleWarningServiceImpl implements ScheduleWarningService {
    @Autowired
    private SchedulePositionDao schedulePositionDao;
    @Autowired
    private PositionDao positionDao;
    @Autowired
    private ScheduleWarningDao scheduleWarningDao;
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private ConsumeService consumeService;


    @Transactional
    public void warning(){
        //对已经投放了时间大于百分之30的进行校验   如果投放的回量小于百分之10的进行提示
        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        String date = DateUtils.getYYMMDD(new Date());
        Double timeRedLine = .3D;
        Double consumeRedLine = .1D;
        List<Schedule> scheduleList = scheduleService.getScheduleByDay(date);
        scheduleWarningDao.deleteByDatestamp(date);
        for(Schedule schedule : scheduleList){
            Double timePer = 0d;
            Double passed = 0d;
            String hours = schedule.getHours();
            if(null!=hours&&!"".equals(hours.trim())){
                hours = hours.trim();
                hours = hours.replaceAll("\\[","").replaceAll("]","").replaceAll(" ","");
                List<String> hourList = CollectionUtils.arrayToList(hours.split(","));
                int total = hourList.size();
                for(int i = 1;i<currentHour;i++){
                    if(hourList.contains((i+""))){
                        passed ++ ;
                    }
                }
                if(passed>0){
                    timePer = passed/total;
                }
                if(timePer<timeRedLine){
                    continue;
                }
                Double cpm = 0D;
                if(schedule.getCpm()!=null){
                    cpm =  cpm + schedule.getCpm() * 1000;
                }
                if(schedule.getRepair()!=null){
                    cpm =  cpm + schedule.getRepair() * 1000;
                }
                if(cpm > 0){
                    if(schedule.getUuid()!=null){
                        Consume consume = consumeService.getRecentActualConsume(schedule.getUuid());
                        if(consume!=null&&consume.getActualConsume()!=null){
                            Double perD = consume.getActualConsume()/cpm;
                            if(perD < consumeRedLine){
                                //save
                                this.save(schedule,consume,perD);
                            }
                        }
                    }
                }
            }

        }
    }
    private void save(Schedule schedule,Consume consume,Double percent){
        String date = DateUtils.getYYMMDD(new Date());
        ScheduleWarning warning = new ScheduleWarning();
        warning.setDateStamp(date);
        warning.setUuid(schedule.getUuid());
        List<SchedulePosition> positions = schedulePositionDao.getByUuid(schedule.getUuid(),date);
        if(null!=positions&&positions.size()>0){
            Long positionId = positions.get(0).getPositionId();
            List<Map<String,Object>> position = positionDao.getPosition(positionId);
            if(null!=position&&position.size()>0){
                if(null!=position.get(0).get("category_name")){
                    warning.setCategory(position.get(0).get("category_name")+"");
                }
                if(null!=position.get(0).get("location_name")){
                    warning.setLocation(position.get(0).get("location_name")+"");
                }
            }
            warning.setActualConsume(consume.getActualConsume());
            warning.setCpm(schedule.getCpm().longValue()+schedule.getRepair().longValue());
            warning.setPercent((int)Math.ceil(percent*100)+"%");
            scheduleWarningDao.insert(warning);
        }
    }
}
