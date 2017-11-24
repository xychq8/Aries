package cn.com.bianlz.web.controller.data.monitor;

import cn.com.bianlz.common.utils.DateUtils;
import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.data.delivery.api.vo.Schedule;
import cn.com.bianlz.web.client.DeliveryServiceClient;
import cn.com.bianlz.web.common.WebApiProtocolCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by bjbianlanzhou on 2017/11/24.
 */
@RestController
public class MonitorController {
    @Autowired
    private DeliveryServiceClient deliveryServiceClient;
    @GetMapping(value={"/monitor/consume/{uuid}"})
    public Result getComsumeMonitor(@PathVariable("uuid")Long uuid){
        Result result = new Result();
        Result<Map<String,Object>> scheduleResult = deliveryServiceClient.getScheduleById(1, 1, DateUtils.getYYMMDD(new Date()),uuid+"");
        if(scheduleResult == null || scheduleResult.getData()==null||scheduleResult.getData()==null){
            result.setCode(WebApiProtocolCode.FAIL.getCode());
            result.setMessage("计划不存在!");
            return result;
        }
        List<Schedule> scheduleList = (List)(scheduleResult.getData().get("data"));
        if(scheduleList.size()<=0){
            result.setCode(WebApiProtocolCode.FAIL.getCode());
            result.setMessage("计划不存在!");
            return result;
        }
        Schedule schedule = scheduleList.get(0);
        String currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+"";
        if(!Arrays.asList(schedule.getHours().split(",")).contains(currentHour)){
            result.setCode(WebApiProtocolCode.FAIL.getCode());
            result.setMessage("不在投放时间!");
            return result;
        }
        Result consumeResult = deliveryServiceClient.getConsume(uuid);
        result.setCode(WebApiProtocolCode.SUCCESS.getCode());
        result.setMessage(WebApiProtocolCode.SUCCESS.getMessage());
        result.setData(consumeResult.getData());
        return result;
    }
}
