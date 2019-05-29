package day1;
public class IfTest4 {
	public static void main(String[] args) {
		int score = (int)(Math.random()*101); //0~100
		char grade;

		// if문을 사용하여
		// 90~100 - "xx점은 A등급"
		// 80~89 - "xx점은 B등급"
		// 70~79 - "xx점은 C등급"
		// 60~69 - "xx점은 D등급"
		// 0~59 - "xx점은 F등급"
		
		if(score>=90)
			grade = 'A';
		else if(score>=80)
			grade = 'B';
		else if(score>=70)
			grade = 'C';
		else if(score>=60)
			grade = 'D';
		else
			grade = 'F';
		
		System.out.println(score + "점은" +grade+"등급");
	}
}
