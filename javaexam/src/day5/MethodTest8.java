package day5;

public class MethodTest8 {
	public static void main(String[] args) {
		int arg1 =MethodLab3.getRandom(1,10);
		int arg2 =MethodLab3.getRandom(10);
		int bigNumber =getBigNumber(arg1,arg2);
		System.out.println("熱ч 唸婁 高 : "+bigNumber);
		if(isEven(bigNumber)) {
			System.out.println("礎熱");
		}
		else {
			System.out.println("�汝�");
		}
	}
	public static int getRandom(int n) {
		int num = (int)(Math.random()*n)+1;
		return num;
	}		
	public static int getRandom(int n1, int n2) {
		int num = (int)(Math.random()*(n2-n1+1))+n1;
		return num;
	}
	static int getBigNumber(int num1, int num2) {
		int bigNumber;
		if(num1<num2)
			bigNumber=num2;
		else
			bigNumber=num1;
		return bigNumber;
	}
	static boolean isEven(int number) {
		boolean result=false;
		if (number%2==0)
			result = true;
		return result;
	}
}
