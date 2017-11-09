package cn.com.bianlz.data.delivery.service;

import cn.com.bianlz.common.utils.DateUtils;
import cn.com.bianlz.data.delivery.api.vo.*;
import cn.com.bianlz.data.delivery.common.ContextEnums;
import cn.com.bianlz.data.delivery.common.ScheduleEnums;
import cn.com.bianlz.data.delivery.dao.*;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bianlanzhou on 17/11/9.
 * Description
 */
@Service
public class ContextServiceImpl implements ContextService {
    @Autowired
    private ContextSexDao contextSexDao;
    @Autowired
    private ContextAgeDao contextAgeDao;
    @Autowired
    private ContextAreaDao contextAreaDao;
    @Autowired
    private ContextOsDao contextOsDao;
    @Autowired
    private ContextNetworkDao contextNetworkDao;
    @Autowired
    private ContextTypeDao contextTypeDao;
    @Autowired
    private ContextInterestDao contextInterestDao;
    @Autowired
    private InterestDao interestDao;
    @Autowired
    private AreaDao areaDao;
    @Override
    public Map<String, Object> getContext(Long uuid) {
        String date = DateUtils.getYYMMDD(new Date());
        Map<String,Object> rtn = new HashMap<String, Object>();
        List<ContextSex> contextSexList = contextSexDao.getByUuid(uuid,date);
        List<ContextAge> contextAgeList = contextAgeDao.getByUuid(uuid,date);
        List<ContextArea> contextAreaList = contextAreaDao.getByUuid(uuid, date);
        List<ContextOs> contextOsList = contextOsDao.getByUuid(uuid, date);
        List<ContextNetwork> contextNetworkList = contextNetworkDao.getByUuid(uuid, date);
        List<ContextType> contextTypeList = contextTypeDao.getByUuid(uuid, date);
        List<ContextInterest> contextInterestList = contextInterestDao.getByUuid(uuid,date);
        rtn.put("contextSex",getContextVal(contextSexList));
        rtn.put("contextAge",getContextVal(contextAgeList));
        rtn.put("contextArea",getContextVal(contextAreaList));
        rtn.put("contextOs",getContextVal(contextOsList));
        rtn.put("contextNetwork",getContextVal(contextNetworkList));
        rtn.put("contextType",getContextVal(contextTypeList));
        rtn.put("contextInterest",getContextVal(contextInterestList));
        return rtn;
    }

    private String getContextVal(List list){
        if(list==null||list.isEmpty()){
            return "-";
        }
        Object obj = list.get(0);
        if(obj==null){
            return "-";
        }
        if(obj instanceof ContextSex){
            Integer sex = ((ContextSex) obj).getSex();
            if(ContextEnums.Sex.MALE.getCode() == sex){
                return ContextEnums.Sex.MALE.getName();
            }else if(ContextEnums.Sex.FEMALE.getCode() == sex){
                return ContextEnums.Sex.FEMALE.getName();
            }else if(ContextEnums.Sex.UNLIMITED.getCode() == sex){
                return ContextEnums.Sex.UNLIMITED.getName();
            }else{
                return ContextEnums.Sex.UNKNOW.getName();
            }
        }else if(obj instanceof ContextNetwork){
            Integer network = ((ContextNetwork) obj).getNetwork();
            if(network == -1){
                return "不限";
            }else if(ContextEnums.Network.WIFI.getCode() == network){
                return ContextEnums.Network.WIFI.getName();
            }else if(ContextEnums.Network._2G.getCode() == network){
                return ContextEnums.Network._2G.getName();
            }else if(ContextEnums.Network._3G.getCode() == network){
                return ContextEnums.Network._3G.getName();
            }else if(ContextEnums.Network._4G.getCode() == network) {
                return ContextEnums.Network._4G.getName();
            }else{
                return ContextEnums.Network.UNKNOW.getName();
            }
        }else if(obj instanceof ContextOs){
            Integer os = ((ContextOs)obj).getOs();
            if(ContextEnums.Os.ANDRIOD.getCode() == os){
                return ContextEnums.Os.ANDRIOD.getName();
            }else if(ContextEnums.Os.IOS.getCode() == os){
                return ContextEnums.Os.IOS.getName();
            }if(ContextEnums.Os.UNLIMITED.getCode() == os){
                return ContextEnums.Os.UNLIMITED.getName();
            }
        }else if(obj instanceof ContextInterest){
            String interest = ((ContextInterest)obj).getInterest();
            if("-1".equals(interest)){
                return "不限";
            }
            String interestsStr = "";
            for(int i = 0;i<list.size();i++){
                interest = ((ContextInterest)list.get(i)).getInterest();
                List<Interest> interests = interestDao.getInterestByCode(interest);
                if(interests!=null&&!interests.isEmpty()){
                    interestsStr = interests.get(0) + "," + interestsStr;
                }
                if(!"".equals(interestsStr)){
                    interestsStr = interestsStr.replaceFirst(",","");
                }
            }
            return interestsStr;
        }else if(obj instanceof ContextArea){
            Integer areaId = ((ContextArea)obj).getArea();
            if(areaId==-1){
                return "全国";
            }
            List<Area> areaList = areaDao.getAreaByIds(list);
            String areaStr = "";
            for(Area area:areaList){
                areaStr = areaStr + "," + area.getAreaName();
            }
            if(!"".equals(areaStr)){
                areaStr = areaStr.replaceFirst(",","");
            }
            return areaStr;
        }else if(obj instanceof ContextAge){
            String age = ((ContextAge)obj).getAge();
            return age;
        }else if(obj instanceof ContextType){
            Integer orderType = ((ContextType) obj).getOrderType();
            if(ScheduleEnums.OrderType.GD.getCode().equals(orderType.toString())){
                return ScheduleEnums.OrderType.GD.getName();
            }
            return ScheduleEnums.OrderType.NGD.getName();
        }

        return "-";
    }
}
