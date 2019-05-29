package day4;

public class LottoMachine1 {
	public static void main(String[] args) {
		int[] arr = new int[6];
		int check = 0;

		for (int i = 0; true; i++) {
			int rNum = (int) (Math.random() * 45) + 1; // 1~45난수
			check = 0; // 체크변수 초기화
			for (int j = 0; j < i; j++) {
				if (arr[j] == rNum) {
					check += 1; // 겹치는 경우 체크에 +1
					i--;
				}
			}
			if (check == 0) { // 체크가 0이라면 배열에 대입, 아니면 루프
				arr[i] = rNum;
			}
			if (arr[5] != 0) // 6개 다차면 루프 나가기
				break;
		}
		System.out.print("오늘의 로또 번호 - ");
		for (int i = 0; i < arr.length; i++) { // 쉼표 출력기
			if (i == arr.length - 1)
				System.out.print(arr[i]);
			else
				System.out.print(arr[i] + ", ");
		}
	}
}
