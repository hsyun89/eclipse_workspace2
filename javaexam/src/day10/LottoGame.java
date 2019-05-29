package day10;

import java.util.Random;

class DuplicateException extends Exception {
	DuplicateException() {
		super("중복된 로또 번호가 발생했습니다.");
	}
}

class LottoMachine {
	private int[] nums;

	public LottoMachine() {
		nums = new int[6];
	}

	public void createLottoNums() {
		Random rand = new Random();
		for (int i = 0; i < nums.length; i++) {
			nums[i] = rand.nextInt(20) + 1;
		}
	}

	public void checkLottoNums() /*throws DuplicateException*/{
		try {
			for (int i = 0; i < nums.length; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i] == nums[j]) {
						throw new DuplicateException();
					}
				}
			}
		} catch (DuplicateException e) {
			System.out.println("오류 발생 : " + e.getMessage());
			System.exit(-1);
//			e.printStackTrace();
		}
	}

	public int[] getNums() {
		return nums;
	}
}

public class LottoGame {
	public static void main(String[] args) {
		LottoMachine lotto1 = new LottoMachine();
		lotto1.createLottoNums();
		lotto1.checkLottoNums();
		// 로또출력 인핸스먼트포
//		for(int data:lotto1.getNums()) {
//			System.out.print(data+"\t");
//		}
		// 로또 출력 트래디셔널포
//		for (int i = 0; i < lotto1.getNums().length; i++) {
//			if (i == 0)
//				System.out.print(lotto1.getNums()[i]);
//			else
//				System.out.print(", " + lotto1.getNums()[i]);
//		}
		//출력 더 좋은 버전
		int[] arr1=lotto1.getNums();
		for (int i = 0; i < arr1.length; i++) {
			if (i == 0)
				System.out.print(arr1[i]);
			else
				System.out.print(", " + arr1[i]);
		}

	}

}
