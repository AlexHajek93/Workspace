package com.revature.dates;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Holidays {
	public static void main(String[] args) {
		Date now = new Date();
		Date future = new Date(9_223_372_036_854_775_807l);
		//Jan 1 1970
		
		Calendar obj = Calendar.getInstance();
		obj.set(1985, Calendar.AUGUST, 20);
		System.out.println(obj.getTime());
		
		Calendar obj1 = Calendar.getInstance();
		obj1.set(1985, Calendar.AUGUST, 20);
		Calendar obj2 = Calendar.getInstance();
		obj2.set(1985, Calendar.AUGUST, 20);
		
		System.out.println(future.getTime());
		System.out.println(now.getTime()+1000*60*60*24);
		DateFormat formatter = DateFormat.getDateInstance();
		SimpleDateFormat fmt = new SimpleDateFormat();
		
		
		System.out.println(compareDatesBefore(obj1,obj2));
	}
	
	//one < two
	public static boolean compareDatesBefore(Calendar one,Calendar two){
		final int YEAR = Calendar.YEAR;
		final int DAY = Calendar.DAY_OF_YEAR;
		final int MILL = Calendar.MILLISECOND;
		if(one.get(YEAR)<two.get(YEAR)) return true;
		else if(one.get(YEAR)==two.get(YEAR)){
			if(one.get(DAY)<two.get(DAY)) return true;
			else if(buildLongMill(one)<buildLongMill(two))
				return false;
		}
		return false;
	}
	
	public static long buildLongMill(Calendar cal){
		final int MILL = Calendar.MILLISECOND;
		final int SEC = Calendar.SECOND;
		final int MIN = Calendar.MINUTE;
		final int HOUR = Calendar.HOUR;
		return (long) (cal.get(MILL)+cal.get(SEC)*1000
				+cal.get(MIN)*60*1000 +cal.get(HOUR)*60*60*1000);
	}
}
