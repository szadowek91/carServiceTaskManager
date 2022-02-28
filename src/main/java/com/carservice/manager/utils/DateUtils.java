package com.carservice.manager.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static String stringDate(Date date){
        return simpleDateFormat.format(date);
    }
}
