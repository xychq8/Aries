package cn.com.bianlz.task;

import cn.com.bianlz.common.utils.DateUtils;
import cn.com.bianlz.common.utils.GsonUtils;
import cn.com.bianlz.data.delivery.api.vo.ContextType;
import cn.com.bianlz.service.ContextService;
import cn.com.bianlz.service.ScheduleService;
import cn.com.bianlz.vo.Schedule;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by bianlanzhou on 17/11/1.
 * Description
 */
@Component
public class ContextTask implements ITask {
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private ContextService contextService;
    @Override
    public void run() {
        try {
            String date = DateUtils.getYYMMDD(new Date());
            String content = Unirest.get("http://c.ka.163.com/mf/mfm?querys=castContext").asString().getBody();
            if(null!=content&&!"".equals(content)){
                Map<String,Map<String,Map<String,Set<Long>>>> contentMap = GsonUtils.getInstances().fromJson(new TypeToken<Map<String,Map<String,Map<String,Set<Long>>>>>(){},content);
                Map<String,Map<String,Set<Long>>> castcontext = (Map)contentMap.get("castContext");
                if(castcontext==null||castcontext.isEmpty()){
                    return;
                }
                try{
                    Map<String,Set<Long>> positionMap = castcontext.get("position");
                    if(positionMap==null&&positionMap.isEmpty()){
                        return;
                    }
                    scheduleService.saveSchedulePosition(date,positionMap);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                try{
                    Map<String,Set<Long>> orderType = castcontext.get("orderType");
                    Set<Long> gdSet = orderType.get("GD");
                    Set<Long> ngdSet = orderType.get("NGD");
                    contextService.saveContextType(gdSet,ngdSet,date);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                try{
                    Map<String,Set<Long>> sexMap = castcontext.get("sex");
                    contextService.saveContextSex(sexMap,date);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                try{
                    Map<String,Set<Long>> areaMap = castcontext.get("area");
                    contextService.saveContextArea(areaMap,date);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                try{
                    Map<String,Set<Long>> osMap = castcontext.get("os");
                    contextService.saveContextOs(osMap, date);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                try{
                    Map<String,Set<Long>> ageMap = castcontext.get("age");
                    contextService.saveContextAge(ageMap, date);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                try{
                    Map<String,Set<Long>> networkMap = castcontext.get("network");
                    contextService.saveContextNetwork(networkMap,date);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                try{
                    Map<String,Set<Long>> interestMap = castcontext.get("interest");
                    contextService.saveContextInterest(interestMap,date);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
