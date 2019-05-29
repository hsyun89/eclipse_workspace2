package day9.test1;

public class TVTest {

	public static void main(String[] args) {
		// 초기값
		SaleTV tv1 = new SaleTV(300000, "SALETV-1", 40, 1);
		RentalTV tv2 = new RentalTV(100000, "RENTALTV-1", 42, 1);
		// 채널업
		tv1.channelUp();
		tv1.channelUp();
		// 채널 다운
		tv2.channelDown();
		tv2.channelDown();
		tv2.channelDown();
		
//		tv1.play();
//		tv1.sale();
//		System.out.println(tv1.toString());
		
		printAllTV(tv1);
		printAllTV(tv2);
		printRentalTV(tv2);
	}
	static void printAllTV(TV tv) {
		if(tv instanceof SaleTV) {  //세일자식 or 렌탈자식 판별
			System.out.println(tv.toString());
			((SaleTV) tv).play(); //부모에는 없는거 고로 강제 형변환이 필요함
			((SaleTV) tv).sale();
		}
		else {
			System.out.println(tv.toString());
			((RentalTV) tv).play();
		}
	}
	static void printRentalTV(Rentable tv) {
		tv.rent();
	}
}

