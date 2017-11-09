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
                    Map<String,Set<Long>> positionMap = castcontext.get("ad.nadp.castcontext.list.position");
                    if(positionMap==null&&positionMap.isEmpty()){
                        return;
                    }
                    scheduleService.saveSchedulePosition(date,positionMap);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                try{
                    Map<String,Set<Long>> gdMap = castcontext.get("ad.nadp.castcontext.list.gd");
                    Map<String,Set<Long>> ngdMap = castcontext.get("ad.nadp.castcontext.list.ngd");
                    Set<Long> gdSet = new HashSet<Long>();
                    Set<Long> ngdSet = new HashSet<Long>();
                    for(Set<Long> set:gdMap.values()){
                        gdSet.addAll(set);
                    }
                    for(Set<Long> set:ngdMap.values()){
                        ngdSet.addAll(set);

                    }
                    contextService.saveContextType(gdSet,ngdSet,date);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                try{
                    Map<String,Set<Long>> sexMap = castcontext.get("ad.nadp.castcontext.list.sex");
                    contextService.saveContextSex(sexMap,date);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                try{
                    Map<String,Set<Long>> areaMap = castcontext.get("ad.nadp.castcontext.list.area");
                    contextService.saveContextArea(areaMap,date);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                try{
                    Map<String,Set<Long>> osMap = castcontext.get("ad.nadp.castcontext.list.os");
                    contextService.saveContextOs(osMap, date);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                try{
                    Map<String,Set<Long>> ageMap = castcontext.get("ad.nadp.castcontext.list.age");
                    contextService.saveContextAge(ageMap, date);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                try{
                    Map<String,Set<Long>> networkMap = castcontext.get("ad.nadp.castcontext.list.network");
                    contextService.saveContextNetwork(networkMap,date);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                try{
                    Map<String,Set<Long>> interestMap = castcontext.get("ad.nadp.castcontext.list.interest");
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
