package cn.com.bianlz.common.utils;

import com.google.gson.Gson;

/**
 * Created by bianlanzhou on 17/9/10.
 * Description
 */
public class GsonUtils {
    private static final GsonUtils instances = new GsonUtils();
    private static final Gson gson = new Gson();
    private GsonUtils(){}
    public static GsonUtils getInstances(){
        return instances;
    }
    public String toJson(Object o){
        return gson.toJson(o);
    }

    public <T> T fromJson(Class<T> t,String json){
        return gson.fromJson(json,t);
    }
}
