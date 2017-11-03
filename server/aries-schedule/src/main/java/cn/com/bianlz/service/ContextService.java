package cn.com.bianlz.service;

import cn.com.bianlz.data.delivery.api.vo.ContextType;

import java.util.List;
import java.util.Set;

/**
 * Created by bianlanzhou on 17/11/3.
 * Description
 */
public interface ContextService {
    void saveContextType(Set<Long> gdSet,Set<Long> ngdSet,String date);
}
