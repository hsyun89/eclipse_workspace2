package day13;

import java.util.GregorianCalendar;

public class Calendar {

	public static void main(String[] args) {
		GregorianCalendar today = new GregorianCalendar();
		System.out.printf("8 : 오늘의 날짜는 %1$tY년 %1$tm월 %1$td일 입니다.\n", today);
	}

}
