package cn.com.bianlz.task;

import cn.com.bianlz.common.ScheduleServerProxy;
import cn.com.bianlz.common.utils.DateUtils;
import cn.com.bianlz.common.utils.GsonUtils;
import cn.com.bianlz.common.utils.MD5Utils;
import cn.com.bianlz.service.ScheduleService;
import cn.com.bianlz.vo.Schedule;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;
import cn.com.bianlz.common.Constants;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by bianlanzhou on 17/10/9.
 * Description
 */
@Component
public class ScheduleTask implements ITask{
    @Autowired
    private ScheduleService scheduleService;
    public void run(){
        try {
            String schedule = ScheduleServerProxy.getInstance().get(Constants.DATA_URL+Constants.DATA_GET_PARAM_SCHEDULE);
            if(schedule!=null&&!"".equals(schedule)){
                Map<String,Schedule> map = GsonUtils.getInstances().fromJson(new TypeToken<Map<String, Schedule>>(){},schedule);
                scheduleService.saveSchedule(map.values());
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
