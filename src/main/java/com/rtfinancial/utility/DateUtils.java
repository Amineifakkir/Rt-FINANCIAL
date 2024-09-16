package com.rtfinancial.utility;



import io.micrometer.common.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {

    private DateUtils() {
    }

    public static String dateToString(Date date) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(date);
    }

    public static String dateToString_(Date date) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return df.format(date);
    }

    public static Date stringToDate(String date) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date stringToDateTime(String date) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String dateTimeFrTiretToString(Date date) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss");
        return df.format(date);
    }

    public static String dateTimeFileName(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss");
        return df.format(date);
    }

    public static String toDateTime(Date date) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return df.format(date);
    }

    public static Date atStartOfDay(Date date) {
        if (date == null) {
            return null;
        }
        LocalDateTime localDateTime = dateToLocalDateTime(date);

        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return localDateTimeToDate(startOfDay);
    }

    public static Date atEndOfDay(Date date) {
        if (date == null) {
            return null;
        }
        LocalDateTime localDateTime = dateToLocalDateTime(date);

        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return localDateTimeToDate(endOfDay);
    }

    private static LocalDateTime dateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    private static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static String toDateTimeMin(Date date) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return df.format(date);
    }

    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static Date getDateFromString(String dateStr, boolean includeHours) {
        String dateFormat = includeHours ? "dd/MM/yyyy HH:mm" : "dd/MM/yyyy";

        Date date = null;
        try {
            date = new SimpleDateFormat(dateFormat).parse(dateStr);
        } catch (ParseException ex) {
            date = null;
        }

        return date;
    }

    public static String dateToStringDateSlash(Date date, Boolean includeHours) {
        String format = includeHours ? "dd/MM/yyyy HH:mm" : "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    public static String dateToStringDateTimeSlash(Date date) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return df.format(date);
    }

    public static String dateToStrNumero(Date date) {
        DateFormat df = new SimpleDateFormat("ddMMyy");
        return df.format(date);
    }

}
