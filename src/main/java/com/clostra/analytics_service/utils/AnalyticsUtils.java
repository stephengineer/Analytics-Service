package com.clostra.analytics_service.utils;

import java.time.LocalDate;

public class AnalyticsUtils {
    /**
     * Get today's date
     * @return today's date in format YYYY-MM-DD
     */
    public static String getToday() {
        LocalDate date = LocalDate.now();
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        StringBuilder buf = new StringBuilder(10);
        return buf.append(year).append("-").append(month < 10 ? "0" : "").append(month).append("-").append(day < 10 ? "0" : "").append(day).toString();
    }

    /**
     * Get today's month
     * @return today's month in format YYYY-MM
     */
    public static String getMonth() {
        LocalDate date = LocalDate.now();
        int year = date.getYear();
        int month = date.getMonthValue();
        StringBuilder buf = new StringBuilder(7);
        return buf.append(year).append("-").append(month < 10 ? "0" : "").append(month).toString();
    }
}
