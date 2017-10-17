package cn.com.bianlz.common.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;


/**
 * Created by bianlanzhou on 17/9/10.
 * Description
 */
public class GsonUtils {
    private static final GsonUtils instances = new GsonUtils();
    private static final Gson gson = new Gson();
    private static final JsonParser jsonParser = new JsonParser();
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

    public <T> T fromJson(TypeToken<T> token,String json){
        return gson.fromJson(json,token.getType());
    }

    public JsonArray fromJson(String json){
        return jsonParser.parse(json).getAsJsonArray();
    }

}
