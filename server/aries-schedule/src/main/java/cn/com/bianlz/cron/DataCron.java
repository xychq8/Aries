package cn.com.bianlz.cron;

import cn.com.bianlz.task.ConsumeStatisticsTask;
import cn.com.bianlz.task.ContextTask;
import cn.com.bianlz.task.ITask;
import cn.com.bianlz.task.ScheduleTask;
import cn.com.bianlz.vo.Schedule;
import cn.com.bianlz.vo.SchedulePosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by bianlanzhou on 17/10/9.
 * Description
 */
@EnableScheduling
@Component
public class DataCron {
    @Autowired
    private ScheduleTask scheduleTask;
    @Autowired
    private ConsumeStatisticsTask consumeStatisticsTask;
    @Autowired
    private ContextTask contextTask;
    @Scheduled(cron = "0 */1 * * * * ")
    public void schedule(){
        //scheduleTask.run();
        contextTask.run();
    }
    @Scheduled(cron = "0 */10 * * * * ")
    public void consume(){
        //consumeStatisticsTask.run();
    }

}
