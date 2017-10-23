package cn.com.bianlz.common.utils;

import org.apache.commons.codec.binary.Base64;
import java.io.UnsupportedEncodingException;

/**
 * Created by bianlanzhou on 17/9/8.
 * Description
 */
public class CodecUtils {
    public static String base64(String str){
        try {
            byte[] bs = Base64.encodeBase64(str.getBytes("UTF-8"));
            return new String(bs,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
