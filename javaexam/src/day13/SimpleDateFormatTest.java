﻿package day13;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {
	public static String timeToStrDate(long time) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(time);
	}
	public static Date parseStrDate(String strDate) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일");
		return formatter.parse(strDate);
	}
	public static void main(String[] args) throws ParseException {
		System.out.println(timeToStrDate(new Date().getTime()));
		System.out.println(parseStrDate("2019년 01월 01일")); 		
	}
}
