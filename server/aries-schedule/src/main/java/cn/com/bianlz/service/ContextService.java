package cn.com.bianlz.service;

import cn.com.bianlz.data.delivery.api.vo.ContextType;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by bianlanzhou on 17/11/3.
 * Description
 */
public interface ContextService {
    void saveContextType(Set<Long> gdSet,Set<Long> ngdSet,String date);

    void saveContextSex(Map<String,Set<Long>> sexIndex,String date);

    void saveContextArea(Map<String,Set<Long>> areaIndex,String date);

    void saveContextOs(Map<String,Set<Long>> osIndex,String date);

    void saveContextNetwork(Map<String,Set<Long>> networkIndex,String date);

    void saveContextAge(Map<String,Set<Long>> ageIndex,String date);
}
