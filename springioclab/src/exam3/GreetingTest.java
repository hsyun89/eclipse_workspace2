package exam3;

import java.time.LocalDateTime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("exam3/app.xml");
		LocalDateTime time = (LocalDateTime) factory.getBean("time");
		int hour=time.getHour();
		System.out.println(hour);
		if(hour>=6 && hour<12) {
			Greeting bean = (Greeting) factory.getBean("morning");
			bean.greet();
		}else if(hour>=12 && hour<17) {
			Greeting bean = (Greeting) factory.getBean("afternoon");
			bean.greet();
		}else if(hour>=17 && hour<22) {
			Greeting bean = (Greeting) factory.getBean("evening");
			bean.greet();
		}else {
			Greeting bean = (Greeting) factory.getBean("night");
			bean.greet();
		}
		((ClassPathXmlApplicationContext) factory).close();
	}

}
