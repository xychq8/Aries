package cn.com.bianlz.common.utils;

import sun.awt.CharsetString;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Created by bianlanzhou on 17/9/8.
 * Description
 */
public class CodecUtils {
    public static String base64(String str){
        try {
            byte[] bs = Base64.getEncoder().encode(str.getBytes("utf-8"));
            return new String(bs,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
