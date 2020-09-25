package com.echair.project_manage.common;

import com.alibaba.fastjson.JSON;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @description:
 * @author: wjk
 * @date: 2020/9/8 16:28
 **/
public class DayUtils {
    public static Date getToday() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
    public static Date getTomorrow() {
        long l = getToday().getTime() + 24 * 60 * 60 * 1000;
        return new Date(l);
    }

    public static void main(String[] args) {
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        Date today = getToday();
        Date tomorrow = getTomorrow();
        System.out.println(sdf.format(today));
        System.out.println(sdf.format(tomorrow));
    }

    /**
     * 获取当前时间和指定时间相隔天数
     * @param date
     * @return
     */
    public static int getDays(Date date) {
        Date now = new Date();
        long one = 24 * 60 * 60 * 1000;
        long count = now.getTime() - date.getTime();
        return count <= 0 ? 0 : (int)(count/one) + 1;
    }
}
