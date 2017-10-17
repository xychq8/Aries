package cn.com.bianlz.data.delivery.controller;

import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.data.delivery.api.vo.Schedule;
import cn.com.bianlz.data.delivery.service.ScheduleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bianlanzhou on 17/10/17.
 * Description
 */
@RestController
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;
    @GetMapping(value={"/schedule/{pageNum}/{count}/{uuid}","/schedule/{pageNum}/{count}"})
    public Result get(@PathVariable("pageNum") Integer pageNum,@PathVariable("count") Integer count,@PathVariable(value = "uuid",required = false) String uuid){
        Result<Map<String,Object>> result = new Result<Map<String, Object>>();
        Map<String,Object> rtn = new HashMap<String, Object>();
        Schedule schedule = new Schedule();
        if(uuid!=null){
            schedule.setUuid(uuid);
        }
        Page page = PageHelper.offsetPage(((pageNum-1)*count), count,true);
        List<Schedule> data = scheduleService.get(schedule);
        rtn.put("data",data);
        rtn.put("total",page.getTotal());
        rtn.put("pages",page.getPages());
        result.setCode("DD10000");
        result.setData(rtn);
        return result;
    }
}
