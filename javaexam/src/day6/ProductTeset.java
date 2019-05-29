package day6;


//메인함수
public class ProductTeset {
	public static void main(String[] args) {
		Product proArr[] = new Product[5];
		proArr[0] = new Product("apple", 5, 2000);
		proArr[1] = new Product("banana", 10, 3000);
		proArr[2] = new Product("kiwi", 15, 4000);
		proArr[3] = new Product("cherry", 6, 5000);
		proArr[4] = new Product();

//		for(int i=0;i<proArr.length;i++) {
//			System.out.println("상품명\t"+proArr[i].getName()+"\t재고량\t"
//		+proArr[i].getBalance()+"\t가격\t" + proArr[i].getPrice());
//		}

		// 트래디셔널 포 사용
//		for(int i=0;i<proArr.length;i++) {
//			System.out.printf("상품명\t%s\t재고량\t%d\t가격\t%,d원\n",
//					proArr[i].getName(),proArr[i].getBalance(),proArr[i].getPrice());
//		}

		// 인헨스먼트 포 사용
		for (Product data : proArr) {
			System.out.printf("%s \t %d \t %,d원\n", data.getName(), data.getBalance(), data.getPrice());
		}

	}

}
