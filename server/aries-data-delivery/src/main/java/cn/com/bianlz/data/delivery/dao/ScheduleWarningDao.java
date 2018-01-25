package cn.com.bianlz.data.delivery.dao;

import cn.com.bianlz.data.delivery.api.vo.ScheduleWarning;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleWarningDao {
    List<ScheduleWarning> getByDay(String dateStamp);
}
