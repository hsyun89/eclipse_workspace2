package day5;

public class MethodTest5 {

	public static void main(String[] args) {
		int result = operate(10, 20);
		System.out.println("호출 결과값1 : " + result);
		System.out.println("호출 결과값2 : " + operate(100, 200));
		result = operate(11, 22) + 100;
		System.out.println("호출 결과값3 : " + result);
		System.out.println(getMyName());
		System.out.println(getMyName('@'));
		//System.out.println(getMyName('$','#'));
	}

	static int operate(int num1, int num2) {
		return num1 + num2;
	}
	//****메서드 오버로딩**** 
	static String getMyName() {
		return "*유니코*";
	}
	static String getMyName(char deco) {
		return deco + "듀크" + deco;
	}
}
