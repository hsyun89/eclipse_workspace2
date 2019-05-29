package day2;
public class SwitchTest4 {
	public static void main(String[] args) {
		int score = (int)(Math.random()*101); //0~100
		int devideScore = score/10;
		char grade =' ';
		
		// if문을 사용하여
		// 90~100 - "xx점은 A등급"
		// 80~89 - "xx점은 B등급"
		// 70~79 - "xx점은 C등급"
		// 60~69 - "xx점은 D등급"
		// 0~59 - "xx점은 F등급" 
		
		switch(devideScore) {
		case 9: case 10:
			grade='A';break;
		case 8:
			grade='B';break;
		case 7:
			grade='C';break;
		case 6:
			grade='D';break;
		default:
			grade='F';
		}
		System.out.println(score + "점은" +grade+"등급");
	}
}
