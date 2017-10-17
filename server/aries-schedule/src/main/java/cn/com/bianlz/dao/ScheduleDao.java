package cn.com.bianlz.dao;

import cn.com.bianlz.vo.Schedule;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleDao {
    int deleteByPrimaryKey(Long sId);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    Schedule selectByPrimaryKey(Long sId);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);

    int deleteByDatestamp(String dateStamp);
}
