package cn.com.bianlz.service;

import cn.com.bianlz.common.utils.DateUtils;
import cn.com.bianlz.common.utils.GsonUtils;
import cn.com.bianlz.dao.ConsumeDao;
import cn.com.bianlz.vo.Consume;
import cn.com.bianlz.vo.Schedule;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by bianlanzhou on 17/10/20.
 * Description
 */
@Service
public class ConsumeServiceImpl implements ConsumeService {
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private ConsumeDao consumeDao;
    @Override
    public List<Map<String,Long>> getConsume() {
        List<Map<String,Long>> rtn = new ArrayList<Map<String, Long>>();
        String date = DateUtils.getYYMMDD(new Date());
        List<Schedule> scheduleList = scheduleService.getScheduleByDay(date);
        int count = 0;
        for(Schedule schedule:scheduleList){
            try {
                String json = Unirest.get("http://data.delivery.com/data/consume/"+schedule.getUuid()).asString().getBody();
                Map<String,Long> map = GsonUtils.getInstances().fromJson(new TypeToken<Map<String,Long>>(){},json);
                map.put("uuid",schedule.getUuid());
                rtn.add(map);
                System.out.println(count++);
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        }
        return rtn;
    }

    @Override
    @Transactional
    public void saveConsume(List<Map<String, Long>> list) {
        String date = DateUtils.getYYMMDD(new Date());
        Consume consumeVo ;
        Long consume = 0l;
        Long actualConsume = 0l;
        for(Map<String,Long> map : list){
            try{
                consumeVo = new Consume();
                consume = map.get("consume");
                actualConsume = map.get("actualConsume");
                consumeVo.setUuid(map.get("uuid"));
                consumeVo.setConsume(consume==null?0:consume);
                consumeVo.setActualConsume(actualConsume==null?0:actualConsume);
                consumeVo.setDateStamp(date);
                consumeDao.insert(consumeVo);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }




}
