package cn.com.bianlz.data.delivery.service;

import cn.com.bianlz.data.delivery.api.vo.Consume;
import cn.com.bianlz.data.delivery.dao.ConsumeDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by bianlanzhou on 17/10/20.
 * Description
 */
public class ConsumeServiceImpl implements ConsumeService{
    @Autowired
    private ConsumeDao consumeDao;
    @Override
    public List<Consume> getConsume(String day, Long uuid) {
        Consume consume = new Consume();
        consume.setDateStamp(day);
        consume.setUuid(uuid);
        return consumeDao.get(consume);
    }
}
