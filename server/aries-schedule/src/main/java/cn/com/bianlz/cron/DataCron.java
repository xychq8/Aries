package cn.com.bianlz.cron;

import cn.com.bianlz.task.*;
import cn.com.bianlz.vo.Schedule;
import cn.com.bianlz.vo.SchedulePosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sun.util.resources.cldr.aa.CalendarData_aa_DJ;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
    @Autowired
    private DoctorTask doctorTask;

    @Scheduled(cron = "0 */30 * * * * ")
    public void schedule(){
        scheduleTask.run();
        contextTask.run();
    }

    @Scheduled(cron = "0 */10 * * * * ")
    public void consume(){
        consumeStatisticsTask.run();
    }

    @Scheduled(cron = "0 */30 * * * * ")
    public void diagnosis(){
        doctorTask.run();
    }


    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date(1515657153946l)));
    }

}
