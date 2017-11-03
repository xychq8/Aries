package cn.com.bianlz.data.delivery.service;

import cn.com.bianlz.common.utils.DateUtils;
import cn.com.bianlz.data.delivery.api.vo.ContextType;
import cn.com.bianlz.data.delivery.api.vo.Position;
import cn.com.bianlz.data.delivery.api.vo.SchedulePosition;
import cn.com.bianlz.data.delivery.dao.ContextTypeDao;
import cn.com.bianlz.data.delivery.dao.PositionDao;
import cn.com.bianlz.data.delivery.dao.SchedulePositionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by bianlanzhou on 17/11/1.
 * Description
 */
@Service
public class SchedulePositionServiceImpl implements SchedulePositionService{
    @Autowired
    private SchedulePositionDao schedulePositionDao;
    @Autowired
    private PositionDao positionDao;
    @Autowired
    private ContextTypeDao contextTypeDao;
    @Override
    public List<Position> getById(Long uuid) {
        List<Position> positions = new ArrayList<Position>();
        String date = DateUtils.getYYMMDD(new Date());
        SchedulePosition schedulePosition = new SchedulePosition();
        schedulePosition.setUuid(uuid);
        schedulePosition.setDateStamp(date);
        List<SchedulePosition> schedulePositionList =  schedulePositionDao.select(schedulePosition);
        for(SchedulePosition sPosition:schedulePositionList){
            List<Position> list = positionDao.getByPositionId(sPosition.getPositionId());
            positions.addAll(list);
        }
        return positions;
    }

    @Override
    public List<Map<String,Object>> getPositionInfo(String day) {
        Integer gdType = 1,ngdType = 2;
        List<Map<String,Object>> rtn = new ArrayList<Map<String, Object>>();
        List<Long> positionIds = schedulePositionDao.selectDistinctPositionByDay(day);
        List<Position> positions = positionDao.getPositionByIds(positionIds);
        for(Position position:positions){
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("position",position);
            List<ContextType> gdContextTypes = contextTypeDao.getByPositionId(day,position.getPositionId(),gdType);
            map.put("gdSize", gdContextTypes == null ? 0 : gdContextTypes.size());
            map.put("gdUuids",getUuidStr(gdContextTypes));
            List<ContextType> ngdContextTypes = contextTypeDao.getByPositionId(day,position.getPositionId(),ngdType);
            map.put("ngdSize", ngdContextTypes == null ? 0 : ngdContextTypes.size());
            map.put("ngdUuids",getUuidStr(ngdContextTypes));
            rtn.add(map);
        }
        return rtn;
    }

    private String getUuidStr(List<ContextType> list){
        String str = "";
        for(ContextType contextType:list){
            str = str + "," + contextType.getUuid();
        }
        if(!"".equals(str)){
            str = str.replaceFirst(",","");
        }
        return str;
    }


}
