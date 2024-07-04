package com.example.bookingapp.Adapter;

import android.text.format.DateFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class ConstantDateItem {
    public static ArrayList<DateItem> getDateItems(int numberOfDays) {
        ArrayList<DateItem> dateList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();

        for (int i = 0; i < numberOfDays; i++) {
            // Generate datetime string
            String datetime = DateFormat.format("MMM dd, yyyy", calendar.getTime()).toString();

            // Get day of the week abbreviation (e.g., "TH" for Thursday)
            String dayAbbreviation = getDayAbbreviation(calendar.get(Calendar.DAY_OF_WEEK));
            // Get day of the month as string (e.g., "02", "03", etc.)
            String dayOfMonth = String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH));

            // Create DateItem and add to list
            dateList.add(new DateItem(dayAbbreviation, dayOfMonth, datetime));

            // Move to the next day
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        return dateList;
    }

    // Helper method to get day abbreviation
    private static String getDayAbbreviation(int dayOfWeek) {
        switch (dayOfWeek) {
            case Calendar.SUNDAY:
                return "SU";
            case Calendar.MONDAY:
                return "MO";
            case Calendar.TUESDAY:
                return "TU";
            case Calendar.WEDNESDAY:
                return "WE";
            case Calendar.THURSDAY:
                return "TH";
            case Calendar.FRIDAY:
                return "FR";
            case Calendar.SATURDAY:
                return "SA";
            default:
                return "";
        }
    }
}
