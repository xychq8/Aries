package cn.com.bianlz.task;

import cn.com.bianlz.service.ConsumeService;
import com.mashape.unirest.http.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by bianlanzhou on 17/10/20.
 * Description
 */
@Component
public class ConsumeStatisticsTask implements ITask {
    @Autowired
    private ConsumeService consumeService;
    @Override
    public void run() {
        List<Map<String,Long>> list = consumeService.getConsume();
        consumeService.saveConsume(list);
    }
}
