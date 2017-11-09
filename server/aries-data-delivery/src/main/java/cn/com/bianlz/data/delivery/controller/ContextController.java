package cn.com.bianlz.data.delivery.controller;

import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.data.delivery.api.vo.DataDeliveryApiProtocolCode;
import cn.com.bianlz.data.delivery.service.ContextService;
import com.mashape.unirest.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by bianlanzhou on 17/11/9.
 * Description
 */
@RestController
public class ContextController {
    @Autowired
    private ContextService contextService;
    @GetMapping(value={"/context/all/{uuid}"})
    public Result<Map<String,Object>> getContext(@PathVariable("uuid")Long uuid){
        Result<Map<String,Object>> result = new Result<Map<String,Object>>();
        result.setCode(DataDeliveryApiProtocolCode.SUCCESS.getCode());
        result.setCode(DataDeliveryApiProtocolCode.SUCCESS.getMessage());
        try {
            result.setData(contextService.getContext(uuid));
        }catch (Exception ex){
            ex.printStackTrace();
            result.setCode(DataDeliveryApiProtocolCode.FAIL.getCode());
            result.setMessage(DataDeliveryApiProtocolCode.FAIL.getMessage());
        }
        return result;
    }
}
