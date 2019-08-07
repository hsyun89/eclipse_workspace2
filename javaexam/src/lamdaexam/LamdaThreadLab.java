package lamdaexam;

import java.util.Calendar;
import java.util.Date;

public class LamdaThreadLab {
	public static void main(String[] args) {

		Thread t1 = new Thread(() -> {
			Calendar cal = Calendar.getInstance();
			for (int i = 0; i < 3; i++) {
				try {
					Thread.sleep(10 * 1000);
				} catch (InterruptedException e) {
				}
				System.out.println("오늘은 " + (cal.get(Calendar.MONTH) + 1) + "월 " + cal.get(Calendar.DAY_OF_MONTH) + "일입니다.");
			}
		});
		Thread t2 = new Thread(() -> {
			Date d = new Date();
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(5 * 1000);
				} catch (InterruptedException e) {
				}
				System.out.println(d.getHours() + "시 " + d.getMinutes() + "분 " + d.getSeconds() + "초");
			}
		});

		t1.start();
		t2.start();
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(3 * 1000);
			} catch (InterruptedException e) {
			}
			System.out.println("number of milliseconds since January 1, 1970, 00:00:00 GMT");
		}

	}
}

//class Thread2_1 implements Runnable {
//	public void run() {
//		Calendar cal = Calendar.getInstance();
//		for(int i=0;i<3;i++) {
//			try {
//				Thread.sleep(10 * 1000);
//			} catch (InterruptedException e) {
//			}
//			System.out.println("오늘은 "+(cal.get(Calendar.MONTH)+1)+"월 "+ cal.get(Calendar.DAY_OF_MONTH)+"일입니다.");
//		}
//	}
//}
//
//class Thread2_2 implements Runnable {
//
//	@Override
//	public void run() {
//		Date d = new Date();
//		for(int i=0;i<5;i++) {
//			try {
//				Thread.sleep(5 * 1000);
//			} catch (InterruptedException e) {
//			}
//			System.out.println(d.getHours()+"시 "+d.getMinutes()+"분 "+d.getSeconds()+"초");
//		}
//	}
//
//}