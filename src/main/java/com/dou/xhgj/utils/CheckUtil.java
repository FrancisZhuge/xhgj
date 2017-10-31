package com.dou.xhgj.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Francis Zhuge
 * @Description: Check服务的工具类
 * @Date: Created in 2017/10/30, 19:09
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class CheckUtil {
    public static Integer getDayNumber(){
        SimpleDateFormat sdfDay = new SimpleDateFormat("dd");
        SimpleDateFormat sdfHour = new SimpleDateFormat("HH");
        int day = Integer.valueOf(sdfDay.format(new Date()));
        int hour = Integer.valueOf(sdfHour.format(new Date()));
        if (hour<8){
            return day-1;
        }else {
            return day;
        }
    }

    public static void main(String[] args) {
        System.out.println(getDayNumber());
    }
}
