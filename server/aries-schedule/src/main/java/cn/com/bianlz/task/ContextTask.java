package cn.com.bianlz.task;

import cn.com.bianlz.common.utils.DateUtils;
import cn.com.bianlz.common.utils.GsonUtils;
import cn.com.bianlz.service.ScheduleService;
import cn.com.bianlz.vo.Schedule;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by bianlanzhou on 17/11/1.
 * Description
 */
@Component
public class ContextTask implements ITask {
    @Autowired
    private ScheduleService scheduleService;
    @Override
    public void run() {
        try {
            String date = DateUtils.getYYMMDD(new Date());
            String content = Unirest.get("http://c.ka.163.com/mf/mfm?querys=castContext").asString().getBody();
            if(null!=content&&!"".equals(content)){
                Map<String,Map<String,Map<String,List<String>>>> contentMap = GsonUtils.getInstances().fromJson(new TypeToken<Map<String,Map<String,Map<String,List<String>>>>>(){},content);
                Map<String,Map<String,List<String>>> castcontext = contentMap.get("castContext");
                if(castcontext==null||castcontext.isEmpty()){
                    return;
                }
                Map<String,List<String>> positionMap = castcontext.get("ad.nadp.castcontext.list.position");
                if(positionMap==null&&positionMap.isEmpty()){
                    return;
                }
                scheduleService.saveSchedulePosition(date,positionMap);
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
