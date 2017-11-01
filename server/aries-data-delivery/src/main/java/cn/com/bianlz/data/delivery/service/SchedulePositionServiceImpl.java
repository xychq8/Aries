package cn.com.bianlz.data.delivery.service;

import cn.com.bianlz.common.utils.DateUtils;
import cn.com.bianlz.data.delivery.api.vo.Position;
import cn.com.bianlz.data.delivery.api.vo.SchedulePosition;
import cn.com.bianlz.data.delivery.dao.PositionDao;
import cn.com.bianlz.data.delivery.dao.SchedulePositionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
}
