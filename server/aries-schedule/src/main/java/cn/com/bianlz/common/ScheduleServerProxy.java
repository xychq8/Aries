package cn.com.bianlz.common;

import cn.com.bianlz.vo.Schedule;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.HttpStatus;

/**
 * Created by bianlanzhou on 17/10/11.
 * Description
 */
public class ScheduleServerProxy {
    private static final ScheduleServerProxy proxy = new ScheduleServerProxy();
    private ScheduleServerProxy(){}
    public static final ScheduleServerProxy getInstance(){
        return proxy;
    }
    public String get(String urlParam) throws UnirestException {
        for(String url:Constants.SERVERS){
            HttpResponse<String> resp = Unirest.get(url+urlParam).asString();
            if(resp.getStatus() == HttpStatus.SC_OK){
                return resp.getBody();
            }
        }
        return null;
    }
}
