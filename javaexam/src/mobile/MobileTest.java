package mobile;


public class MobileTest {
	public static void main(String[] args) {
		Ltab tab1 = new Ltab("Ltab",500,"ABC-01");
		Otab tab2 = new Otab("Otab",1000,"XYZ-20");
		//초기값출력
		printTitle();
		printMobile(tab1);
		printMobile(tab2);
		//10분 충전 후 출력
		System.out.println("\n[10분 충전]");
		tab1.charge(10);
		tab2.charge(10);
		printTitle();
		printMobile(tab1);
		printMobile(tab2);
		//10분 충전 후 출력
		System.out.println("\n[5분 통화]");
		tab1.operate(5);
		tab2.operate(5);
		printTitle();
		printMobile(tab1);
		printMobile(tab2);
		
	}
	public static void printTitle() {
		System.out.println("Mobile"+"\t"+"Battery"+"\t"+"os");
		System.out.println("--------------------------");
	}
	public static void printMobile(Mobile mobile) {
		System.out.println(mobile.getMobileName()+"\t"+mobile.getBatterySize()+"\t"+mobile.getOsType());
	}

}
