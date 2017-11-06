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
        if(UserProtocolCode.SUCCESS.getCode().equals(userResult.getCode())){
            result.setCode(WebApiProtocolCode.SUCCESS.getCode());
            result.setMessage(WebApiProtocolCode.SUCCESS.getMessage());
        }else if(DataDeliveryApiProtocolCode.SUCCESS.getCode().equals(userResult.getCode())){
            result.setCode(WebApiProtocolCode.SUCCESS.getCode());
            result.setMessage(WebApiProtocolCode.SUCCESS.getMessage());
        }else{
            result.setCode(WebApiProtocolCode.FAIL.getCode());
            result.setMessage(WebApiProtocolCode.FAIL.getMessage());
        }
        return result;
    }
}
