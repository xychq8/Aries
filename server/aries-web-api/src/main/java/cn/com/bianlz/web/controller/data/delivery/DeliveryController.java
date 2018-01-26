package cn.com.bianlz.web.controller.data.delivery;

import cn.com.bianlz.common.utils.DateUtils;
import cn.com.bianlz.common.utils.GsonUtils;
import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.data.delivery.api.vo.ScheduleWarning;
import cn.com.bianlz.web.client.DeliveryServiceClient;
import cn.com.bianlz.web.common.Authorizition;
import cn.com.bianlz.web.common.Download;
import cn.com.bianlz.web.service.ScheduleService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by bianlanzhou on 17/10/17.
 * Description
 */
@RestController
@Authorizition
public class DeliveryController {
    @Autowired
    private DeliveryServiceClient deliveryServiceClient;
    @Autowired
    private ScheduleService scheduleService;
    @GetMapping(value={"/data/schedule/{pageNum}/{pageSize}/{day}","/data/schedule/{pageNum}/{pageSize}/{day}/{uuid}"})
    public Result getSchedule(@PathVariable("pageNum") Integer pageNum,@PathVariable("pageSize") Integer pageSize,@PathVariable(value = "day") String day,@PathVariable(value = "uuid",required = false) String uuid){
        if(uuid!=null){
            return deliveryServiceClient.getScheduleById(pageNum, pageSize,day,uuid);
        }else{
            return deliveryServiceClient.getSchedule(pageNum,pageSize,day);
        }

    }

    @GetMapping(value={"/data/consume/{uuid}/{day}","/data/consume/{uuid}"})
    public Result getConsume(@PathVariable("uuid")Long uuid,@PathVariable(value = "day",required = false)String day){
        if(day==null){
            return deliveryServiceClient.getConsume(uuid);
        }
        return deliveryServiceClient.getConsumeByDay(uuid,day);
    }


    @GetMapping(value={"/data/position/uuid/{uuid}"})
    public Result getPositionByUuid(@PathVariable("uuid")Long uuid){
        return deliveryServiceClient.getPositionById(uuid);
    }

    @PostMapping(value={"/data/position/info"})
    public Result getPositionInfo(@RequestBody  List<String> apps){
        return deliveryServiceClient.getPositionInfo(apps);
    }


    @GetMapping(value={"/data/context/all/{uuid}"})
    public Result getPositionInfo(@PathVariable("uuid")Long uuid){
        return deliveryServiceClient.getContext(uuid);
    }

    @GetMapping(value={"/download/warning/excel"})
    @Download
    public void getWarningByDatestamp(HttpServletResponse response){
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment; filename=warning.xls");
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            HSSFWorkbook workbook = scheduleService.createWarningScheduleExcel();
            workbook.write(out);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @GetMapping(value={"/data/warning/indexes"})
    public Result getDeliveryIndexes(){
        String date = DateUtils.getYYMMDD(new Date());
        return deliveryServiceClient.getScheduleIndex(date);
    }
}
