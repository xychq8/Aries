package cn.com.bianlz.service;

import cn.com.bianlz.dao.ContextTypeDao;
import cn.com.bianlz.data.delivery.api.vo.ContextType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by bianlanzhou on 17/11/3.
 * Description
 */
@Service
public class ContextServiceImpl implements ContextService {
    @Autowired
    private ContextTypeDao contextTypeDao;
    @Override
    @Transactional
    public void saveContextType(Set<Long> gdSet,Set<Long> ngdSet,String date) {
        Integer gdType = 1,ngdType = 2;
        contextTypeDao.deleteByDay(date);
        ContextType contextType = null;
        for(Long uuid:gdSet){
            contextType = new ContextType();
            contextType.setDateStamp(date);
            contextType.setUuid(uuid);
            contextType.setOrderType(gdType);
            contextTypeDao.insert(contextType);
        }
        for(Long uuid:ngdSet){
            contextType = new ContextType();
            contextType.setDateStamp(date);
            contextType.setUuid(uuid);
            contextType.setOrderType(ngdType);
            contextTypeDao.insert(contextType);
        }
    }
}
