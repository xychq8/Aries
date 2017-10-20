package cn.com.bianlz.data.delivery.service;

import cn.com.bianlz.data.delivery.api.vo.Consume;

import java.util.List;

/**
 * Created by bianlanzhou on 17/10/20.
 * Description
 */
public interface ConsumeService {
    public List<Consume> getConsume(String day,Long uuid);
}
