package com.example.sha.fish03.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getTime() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

}
