package cn.com.bianlz.dao;

import cn.com.bianlz.vo.ScheduleWarning;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleWarningDao {
    int insert(ScheduleWarning scheduleWarning);
    void deleteByDatestamp(String datestamp);
}
