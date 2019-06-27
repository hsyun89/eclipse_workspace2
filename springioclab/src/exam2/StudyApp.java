package exam2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class StudyApp {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("exam2/app.xml");
		Student bean = (Student) factory.getBean("st1");
		System.out.println(bean.getName()+"는 "+KoreanUtil.getComleteWordByJongsung(bean.getMyHomework().getHomeworkName(), "을", "를")+" 학습합니다.");
		Student bean2 = (Student) factory.getBean("st2");
		System.out.println(bean2.getName()+"는 "+KoreanUtil.getComleteWordByJongsung(bean2.getMyHomework().getHomeworkName(), "을", "를")+" 학습합니다.");
		Student bean3 = (Student) factory.getBean("st3");
		System.out.println(bean3.getName()+"는 "+KoreanUtil.getComleteWordByJongsung(bean3.getMyHomework().getHomeworkName(), "을", "를")+" 학습합니다.");
		((ClassPathXmlApplicationContext) factory).close();
	}
}
class KoreanUtil {
    public static final String getComleteWordByJongsung(String name, String firstValue, String secondValue) {
        char lastName = name.charAt(name.length() - 1);
        // 한글의 제일 처음과 끝의 범위밖일 경우는 오류
        if (lastName < 0xAC00 || lastName > 0xD7A3) {
            return name;
        }
        String seletedValue = (lastName - 0xAC00) % 28 > 0 ? firstValue : secondValue;
        return name+seletedValue;
    }

}
