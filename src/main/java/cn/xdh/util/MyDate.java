package cn.xdh.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate {
    public static String time(int timeStamp){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(timeStamp*1000L);
        return simpleDateFormat.format(date);
    }
}
