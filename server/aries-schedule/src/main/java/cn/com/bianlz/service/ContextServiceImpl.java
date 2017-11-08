package cn.com.bianlz.service;

import cn.com.bianlz.dao.*;
import cn.com.bianlz.data.delivery.api.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by bianlanzhou on 17/11/3.
 * Description
 */
@Service
public class ContextServiceImpl implements ContextService {
    @Autowired
    private ContextTypeDao contextTypeDao;
    @Autowired
    private ContextSexDao contextSexDao;
    @Autowired
    private ContextAreaDao contextAreaDao;
    @Autowired
    private ContextOsDao contextOsDao;
    @Autowired
    private ContextNetworkDao contextNetworkDao;
    @Autowired
    private ContextAgeDao contextAgeDao;
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

    @Override
    @Transactional
    public void saveContextSex(Map<String, Set<Long>> sexIndex, String date) {
        Integer male = 1,female = 2,all = 0;
        Set<Long> maleSet = sexIndex.get(male.toString());
        Set<Long> femaleSet = sexIndex.get(female.toString());
        Set<Long> unlimitedSet = new HashSet<Long>();
        unlimitedSet.addAll(maleSet);
        unlimitedSet.retainAll(femaleSet);
        maleSet.removeAll(unlimitedSet);
        femaleSet.removeAll(unlimitedSet);
        contextSexDao.deleteByDay(date);
        saveContextSex(unlimitedSet,all,date);
        saveContextSex(maleSet,all,date);
        saveContextSex(femaleSet,all,date);
    }

    @Override
    public void saveContextArea(Map<String, Set<Long>> areaIndex, String date) {
        String unlimit = "-1";
        contextAreaDao.deleteByDay(date);
        Set<Long> unlimitSet = areaIndex.get(unlimit);
        ContextArea contextArea = null;
        contextAreaDao.deleteByDay(date);
        for(Long uuid:unlimitSet){
            contextArea = new ContextArea();
            contextArea.setUuid(uuid);
            contextArea.setDateStamp(date);
            contextArea.setArea(-1);
            contextAreaDao.insert(contextArea);
        }
        for(Map.Entry<String,Set<Long>> entry : areaIndex.entrySet()){
            String key = entry.getKey();
            if(unlimit.equals(key)){
                continue;
            }
            for(Long uuid:entry.getValue()){
                contextArea = new ContextArea();
                contextArea.setUuid(uuid);
                contextArea.setDateStamp(date);
                contextArea.setArea(Integer.valueOf(key));
                contextAreaDao.insert(contextArea);
            }
        }
    }

    @Override
    public void saveContextOs(Map<String, Set<Long>> osIndex, String date) {
        Integer unlimit = -1,andriod = 1,ios = 2;
        contextOsDao.deleteByDay(date);
        Set<Long> unlimitedSet = new HashSet<Long>();
        Set<Long> andriodSet = osIndex.get(andriod.toString());
        Set<Long> iosSet = osIndex.get(ios.toString());
        unlimitedSet.addAll(andriodSet);
        unlimitedSet.retainAll(iosSet);
        andriodSet.retainAll(unlimitedSet);
        iosSet.retainAll(unlimitedSet);
        saveContextOs(unlimitedSet,unlimit,date);
        saveContextOs(andriodSet,andriod,date);
        saveContextOs(iosSet,ios,date);
    }

    @Override
    @Transactional
    public void saveContextNetwork(Map<String, Set<Long>> networkIndex, String date) {
        String unlimit="-1",wifi = "1",_2G = "2",_3G = "3",_4G = "4";
        contextNetworkDao.deleteByDay(date);
        Set<Long> unlimitedSet = new HashSet<Long>();
        Set<Long> wifiSet = networkIndex.get(wifi);
        Set<Long> _2GSet = networkIndex.get(_2G);
        Set<Long> _3GSet = networkIndex.get(_3G);
        Set<Long> _4GSet = networkIndex.get(_4G);
        unlimitedSet.addAll(wifiSet);
        unlimitedSet.retainAll(_2GSet);
        unlimitedSet.retainAll(_3GSet);
        unlimitedSet.retainAll(_4GSet);
        wifiSet.removeAll(unlimitedSet);
        _2GSet.removeAll(unlimitedSet);
        _3GSet.removeAll(unlimitedSet);
        _4GSet.removeAll(unlimitedSet);
        saveNetwork(unlimitedSet,Integer.valueOf(unlimit),date);
        saveNetwork(wifiSet,Integer.valueOf(wifi),date);
        saveNetwork(_2GSet,Integer.valueOf(_2G),date);
        saveNetwork(_3GSet,Integer.valueOf(_3G),date);
        saveNetwork(_4GSet,Integer.valueOf(_4G),date);
    }

    @Override
    @Transactional
    public void saveContextAge(Map<String, Set<Long>> ageIndex, String date) {
        String max = "100",min = "0";
        //等于100和0的都是不限的
        Set<Long> unlimitedSet = new HashSet<Long>();
        unlimitedSet.addAll(ageIndex.get(max));
        Map<Long,String> ageMap = new HashMap<Long, String>();
        contextAgeDao.deleteByDay(date);
        for(int i = 1;i<=99;i++){
            Set<Long> set = ageIndex.get(i + "");
            if(set==null||set.isEmpty()){
                continue;
            }
            set.removeAll(unlimitedSet);
            if(set==null||set.isEmpty()){
                continue;
            }
            for(Long uuid:set){
                if(ageMap.get(uuid)==null){
                    ageMap.put(uuid,i+"-"+i);
                }else{
                    String ageRange = ageMap.get(uuid);
                    String[] rangeStrs = ageRange.split("-");
                    String range = rangeStrs[0]+"-"+i;
                    ageMap.put(uuid,range);
                }
            }
        }
        ContextAge contextAge = null;
        for(Long uuid:unlimitedSet){
            contextAge = new ContextAge();
            contextAge.setUuid(uuid);
            contextAge.setAge("不限");
            contextAge.setDateStamp(date);
            contextAgeDao.insert(contextAge);
        }
        for(Map.Entry<Long,String> entry : ageMap.entrySet()){
            contextAge = new ContextAge();
            contextAge.setUuid(entry.getKey());
            contextAge.setAge(entry.getValue());
            contextAge.setDateStamp(date);
            contextAgeDao.insert(contextAge);
        }
    }


    private void saveContextSex(Set<Long> set,Integer type,String date){
        ContextSex contextSex = null;
        for(Long uuid:set){
            contextSex = new ContextSex();
            contextSex.setUuid(uuid);
            contextSex.setDateStamp(date);
            contextSex.setSex(type);
            contextSexDao.insert(contextSex);
        }
    }

    private void saveContextOs(Set<Long> set,Integer type,String date){
        ContextOs contextOs = null;
        for(Long uuid:set){
            contextOs = new ContextOs();
            contextOs.setUuid(uuid);
            contextOs.setDateStamp(date);
            contextOs.setOs(type);
            contextOsDao.insert(contextOs);
        }
    }

    private void saveNetwork(Set<Long> set,Integer type,String date){
        ContextNetwork context = null;
        for(Long uuid:set){
            context = new ContextNetwork();
            context.setUuid(uuid);
            context.setDateStamp(date);
            context.setNetwork(type);
            contextNetworkDao.insert(context);
        }
    }

}
