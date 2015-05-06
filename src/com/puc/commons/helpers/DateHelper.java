package com.puc.commons.helpers;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateHelper {

	public static Date toDate(String data) {
		if (data == null || data.equals(""))
			return null;
		Date date = null;
		try {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			date = new Date(((java.util.Date) formatter.parse(data)).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date toDate(String data,String format) {
		if (data == null || data.equals(""))
			return null;
		Date date = null;
		try {
			DateFormat formatter = new SimpleDateFormat(format);
			date = new Date(((java.util.Date) formatter.parse(data)).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static String toString(Date date) {
		if ((date==null) || (date.equals("")))
			return "";
		String d[] = date.toString().split("-");
		return d[2]+"/"+d[1]+"/"+d[0];
	}

	public static Date getToday() {
		Calendar c = GregorianCalendar.getInstance();
		c.set(Calendar.MILLISECOND, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.HOUR,0);
		return new Date(c.getTimeInMillis());
	}
	
	public static Date addMonth(java.util.Date date, Integer months) {
		Date calculatedDate = null;

        if (date != null) {
            final GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, months);
            calculatedDate = new java.sql.Date(calendar.getTime().getTime());
        }

        return calculatedDate;
	}
}
