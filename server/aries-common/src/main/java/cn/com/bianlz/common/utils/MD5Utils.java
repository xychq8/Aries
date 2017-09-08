package cn.com.bianlz.common.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by bianlanzhou on 17/9/1.
 * Description
 */
public class MD5Utils {
    public static String getMD5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(md5.digest(str.getBytes("utf-8")));
    }
}
