package cn.com.bianlz.dao;

import cn.com.bianlz.vo.SchedulePosition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bianlanzhou on 17/11/1.
 * Description
 */
@Repository
public interface SchedulePositionDao {
    int deleteByPrimaryKey(Integer id);

    int deleteByDay(String datestamp);

    int insert(SchedulePosition record);

    int insertSelective(SchedulePosition record);

    SchedulePosition selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SchedulePosition record);

    int updateByPrimaryKey(SchedulePosition record);

    List<SchedulePosition> getByUuid(@Param("uuid")Long uuid, @Param("dateStamp")String dateStamp);
}

