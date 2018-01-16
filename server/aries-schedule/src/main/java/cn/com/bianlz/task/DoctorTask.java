package cn.com.bianlz.task;

import cn.com.bianlz.service.ScheduleWarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoctorTask implements ITask{
    @Autowired
    private ScheduleWarningService scheduleWarningService;
    @Override
    public void run() {
        try {
            scheduleWarningService.warning();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Double per = .001d;
        System.out.println((int)Math.floor(per*100));
    }
}
