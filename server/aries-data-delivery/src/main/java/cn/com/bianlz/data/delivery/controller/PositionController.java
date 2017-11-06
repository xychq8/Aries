package cn.com.bianlz.data.delivery.controller;

import cn.com.bianlz.common.utils.DateUtils;
import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.data.delivery.api.vo.DataDeliveryApiProtocolCode;
import cn.com.bianlz.data.delivery.api.vo.Position;
import cn.com.bianlz.data.delivery.api.vo.Schedule;
import cn.com.bianlz.data.delivery.service.SchedulePositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by bianlanzhou on 17/11/1.
 * Description
 */
@RestController
public class PositionController {
    @Autowired
    private SchedulePositionServiceImpl schedulePositionService;
    @GetMapping(value={"/position/uuid/{uuid}"})
    public Result getById(@PathVariable("uuid") Long uuid){
        Result<List<Position>> result = new Result<List<Position>>();
        result.setCode(DataDeliveryApiProtocolCode.SUCCESS.getCode());
        result.setCode(DataDeliveryApiProtocolCode.FAIL.getMessage());
        try{
            List<Position> list = schedulePositionService.getById(uuid);
            result.setData(list);
            result.setCode("DD10000");
        }catch (Exception ex){
            ex.printStackTrace();
            result.setCode(DataDeliveryApiProtocolCode.FAIL.getCode());
            result.setMessage(DataDeliveryApiProtocolCode.FAIL.getMessage());
        }
        return result;
    }

    @PostMapping(value={"/position/info"})
    public Result getById(@RequestBody List<String> apps){
        System.out.println("arrays:"+Arrays.toString(apps.toArray()));
        String date = DateUtils.getYYMMDD(new Date());
        Result<List<Map<String,Object>>> result = new Result<List<Map<String,Object>>>();
        result.setCode(DataDeliveryApiProtocolCode.SUCCESS.getCode());
        result.setCode(DataDeliveryApiProtocolCode.FAIL.getMessage());
        try{
            List<Map<String,Object>> infoList = schedulePositionService.getPositionInfo(date);
            result.setData(infoList);
            result.setCode("DD10000");
        }catch (Exception ex){
            ex.printStackTrace();
            result.setCode(DataDeliveryApiProtocolCode.FAIL.getCode());
            result.setMessage(DataDeliveryApiProtocolCode.FAIL.getMessage());
        }
        return result;
    }
}
