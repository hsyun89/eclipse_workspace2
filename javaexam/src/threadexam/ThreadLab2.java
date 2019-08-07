package threadexam;

import java.text.SimpleDateFormat;
import java.util.Locale;

class ThreadLab2 {
	public static void main(String args[]) {
		SimpleDateFormat f1 = new SimpleDateFormat ( "HH:mm:ss", Locale.KOREA );
		
		Runnable r1  = new ThreadLab2_1();
		Runnable r2  = new ThreadLab2_2();
		Thread   t1 = new Thread(r1);	
		Thread   t2 = new Thread(r2);	
		
		t1.start(); 
		t2.start(); 
		for(int i=0;i<10;i++) {
			System.out.println("number of milliseconds since January 1, 1970, "+f1.format(System.currentTimeMillis()));
			try {
				Thread.sleep(3000);
			}catch(Exception e) {}
		}
	}
}

class ThreadLab2_1 implements Runnable {
	public void run() {
		SimpleDateFormat f2 = new SimpleDateFormat ( "MM월 dd일", Locale.KOREA );
		for(int i=0; i < 3; i++) {
			System.out.println("오늘은 "+f2.format((System.currentTimeMillis()))+"입니다."); 
			try {
				Thread.sleep(10000);
			}catch(Exception e) {}
		}
	}
}

class ThreadLab2_2 implements Runnable {
	public void run() {
		SimpleDateFormat f3 = new SimpleDateFormat ( "HH시mm분ss초", Locale.KOREA );
		for(int i=0; i < 5; i++) {
		    System.out.println(f3.format((System.currentTimeMillis())));
		    try {
		    	Thread.sleep(5000);
		    }catch(Exception e) {}
		}
	}
}