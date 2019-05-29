package day2;

public class SwitchTest3 {
	public static void main(String[] args){
		int month = (int)(Math.random()*12)+1;
		System.out.println("추출된 값 =" + month);
		
	/*	if(month ==12 || month ==1 || month ==2)
			System.out.println(month+" : 겨울");
		else if(month ==3 || month ==4 || month ==5)
			System.out.println(month+" : 봄");
		else if(month ==6 || month ==7 || month ==8)
			System.out.println(month+" : 여름");
		else
			System.out.println(month+" : 가을"); 
		*/
		
		switch(month) {
		case 12: case 1: case 2: 
			System.out.println(month+"월은 겨울");
			break;
		case 3: case 4: case 5: 
			System.out.println(month+"월은 봄");
			break;
		case 6: case 7: case 8: 
			System.out.println(month+"월은 여름");
			break;
		default : 
			System.out.println(month+"월은 가을");
		}
	}
}
