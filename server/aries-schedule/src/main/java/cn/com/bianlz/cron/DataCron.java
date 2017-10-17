package cn.com.bianlz.cron;

import cn.com.bianlz.task.ITask;
import cn.com.bianlz.task.ScheduleTask;
import cn.com.bianlz.vo.Schedule;
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
    @Scheduled(cron = "0 */1 * * * * ")
    public void schedule(){
        scheduleTask.run();
    }
}
