package cn.com.bianlz.data.delivery.service;

import java.util.Map;

/**
 * Created by bianlanzhou on 17/11/9.
 * Description
 */
public interface ContextService {
    public Map<String,Object> getContext(Long uuid);
}
