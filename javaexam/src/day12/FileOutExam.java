package day12;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;



public class FileOutExam {
	public static void main(String[] args) {
		//선언
		GregorianCalendar calendar = new GregorianCalendar();
		int year=calendar.get(Calendar.YEAR);  //년
		int month=(calendar.get(Calendar.MONTH)+1); //월
		int date=calendar.get(Calendar.DATE); //일
		String dayOf=dayOfWeek(calendar); //요일
		String dayOfMy=specialDayOfWeek(calendar,1989,10,31); //특정한 날의 요일
		//본문
		String dir = "c:/iotest";
		  File f = new File(dir);
	      if(!f.exists()) {
	    	  f.mkdirs();
	      }
		try (FileWriter writer = new FileWriter("c:/iotest/today.txt"); PrintWriter out = new PrintWriter(writer)) {
			out.println("오늘은 "+year+"년 "+month+"월 "+date+"일입니다.");
			out.println("오늘은 "+dayOf+"요일입니다.");
			out.println("윤현수는 "+dayOfMy+"요일에 태어났습니다.");
			System.out.println("저장이 완료되었습니다.");
		} catch (IOException ioe) {
			System.out.println("파일에 저장하는 동안 오류가 발생했습니다.");
		}
	}
	//특정날짜 요일 계산기
	static String specialDayOfWeek(GregorianCalendar calendar, int year, int month, int date){
		String day=null;
		calendar.set(year, month-1, date);  //월에서 1을 빼줘야함
		switch(calendar.get(Calendar.DAY_OF_WEEK)) {
		case 1 :
			day="일";
			break;
		case 2 :
			day="월";
			break;
		case 3 :
			day="화";
			break;
		case 4 :
			day="수";
			break;
		case 5 :
			day="목";
			break;
		case 6 :
			day="금";
			break;
		case 7 :
			day="토";
			break;
		}
		return day;
	}
	//오늘의 요일 계산기
	static String dayOfWeek(GregorianCalendar calendar){
		String day=null;
		switch(calendar.get(Calendar.DAY_OF_WEEK)) {
		case 1 :
			day="일";
			break;
		case 2 :
			day="월";
			break;
		case 3 :
			day="화";
			break;
		case 4 :
			day="수";
			break;
		case 5 :
			day="목";
			break;
		case 6 :
			day="금";
			break;
		case 7 :
			day="토";
			break;
		}
		return day;
	}
}
