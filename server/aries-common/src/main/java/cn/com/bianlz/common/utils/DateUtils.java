package cn.com.bianlz.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bianlanzhou on 17/10/10.
 * Description
 */
public class DateUtils {
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    public static String getYYMMDD(Date date){
        return sdf.format(date);
    }


    public static void main(String[] args) {
        System.out.println(getYYMMDD(new Date()));
    }
}
