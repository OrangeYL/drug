package com.orange.drug.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转换工具类
 */
public class DateUtil {

    public static String dateConvert(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
}
