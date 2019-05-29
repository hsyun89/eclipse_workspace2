package day3;

public class ArrayLab2 {

	public static void main(String[] args) {
		char[] arr = new char[] { 'J', 'a', 'v', 'a' };// 입력
		for (int i = 0; i < arr.length; i++) {
			if ('A' <= arr[i] && arr[i] <= 'Z')// 대문자일 경우
				arr[i] = (char) (arr[i] + 32);
			else// 소문자일 경우
				arr[i] = (char) (arr[i] - 32);
		}
		System.out.print("변환된 배열 : ");// 출력
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1)
				System.out.print(arr[i]);
			else
				System.out.print(arr[i] + ",");
		}
	}

}
