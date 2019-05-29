package work;

public class PlaneTest {

	public static void main(String[] args) {
		// 입력, 여러 종류의 객체를 배열로 다루기
		Plane list[] = new Plane[2];
		list[0] = new Airplane("L747", 1000);
		list[1] = new Cargoplane("C40", 1000);

		// 초기값 출력
		printInfo(list);

		// 100운항
		System.out.println("\n[100운항]");
		for (int i = 0; i < list.length; i++) {
			list[i].flight(100);
		}
		printInfo(list);

		// 200주유
		System.out.println("\n[200주유]");
		for (int i = 0; i < list.length; i++) {
			list[i].reFuel(200);
		}
		printInfo(list);

	}
	//배열 출력 메서드
	public static void printInfo(Plane[] list) {
		System.out.println("Plane" + "\t" + "fuelSize");
		System.out.println("-----------------");
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i].getPlaneName() + "\t");
			System.out.println(list[i].getFuelSize());
		}
	}
}
