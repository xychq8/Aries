package cn.com.bianlz.web.client;

import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.data.delivery.api.vo.ScheduleWarning;
import cn.com.bianlz.web.common.ServiceHelper;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by bianlanzhou on 17/10/17.
 * Description
 */
@FeignClient(name = ServiceHelper.DATA_DELIVERY_SERVICE)
public interface DeliveryServiceClient {
    @RequestMapping(value="/data/delivery/schedule/list/{pageNum}/{pageSize}/{day}",method = RequestMethod.GET)
    public Result getSchedule(@PathVariable("pageNum") Integer pageNum,@PathVariable("pageSize") Integer pageSize,@PathVariable("day") String day);

    @RequestMapping(value="/data/delivery/schedule/list/{pageNum}/{pageSize}/{day}/{uuid}",method = RequestMethod.GET)
    public Result getScheduleById(@PathVariable("pageNum") Integer pageNum,@PathVariable("pageSize") Integer pageSize,@PathVariable("day") String day,@PathVariable("uuid") String uuid);

    @RequestMapping(value={"/data/delivery/consume/{uuid}"},method = RequestMethod.GET)
    public Result getConsume(@PathVariable("uuid")Long uuid);

    @RequestMapping(value={"/data/delivery/consume/{uuid}/{day}"},method = RequestMethod.GET)
    public Result getConsumeByDay(@PathVariable("uuid")Long uuid,@PathVariable(value = "day",required = false)String day);

    @RequestMapping(value={"/data/delivery/position/uuid/{uuid}"},method = RequestMethod.GET)
    public Result getPositionById(@PathVariable("uuid")Long uuid);

    @RequestMapping(value={"/data/delivery/position/info"},method = RequestMethod.POST)
    public Result getPositionInfo(List<String> apps);

    @RequestMapping(value={"/data/delivery/context/all/{uuid}"},method = RequestMethod.GET)
    public Result getContext(@PathVariable("uuid")Long uuid);

    @RequestMapping(value={"/schedule/warning/getWarnningByDatestamp/{dateStamp}"},method = RequestMethod.GET)
    public Result getWarnning(@PathVariable("dateStamp")String dateStamp);

}
