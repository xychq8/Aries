package cn.com.bianlz.web.common;

import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.data.delivery.api.vo.DataDeliveryApiProtocolCode;
import cn.com.bianlz.user.api.protocol.UserProtocolCode;

/**
 * Created by bianlanzhou on 17/9/20.
 * Description
 */
public class ResultHelper {
    public static Result getUserResult(Result userResult){
        Result result = new Result();
        if(userResult==null){
            result.setCode(WebApiProtocolCode.FAIL.getCode());
            result.setMessage(WebApiProtocolCode.FAIL.getMessage());
        }
        result = userResult;
        if(result.getCode().equals(UserProtocolCode.SUCCESS.getCode())){
            result.setCode(WebApiProtocolCode.SUCCESS.getCode());
            result.setMessage(WebApiProtocolCode.SUCCESS.getMessage());
        }else if(result.getCode().equals(DataDeliveryApiProtocolCode.SUCCESS.getCode())){
            result.setCode(WebApiProtocolCode.SUCCESS.getCode());
            result.setMessage(WebApiProtocolCode.SUCCESS.getMessage());
        }else{
            result.setCode(WebApiProtocolCode.FAIL.getCode());
            result.setMessage(WebApiProtocolCode.FAIL.getMessage());
        }
        return result;
    }
}
