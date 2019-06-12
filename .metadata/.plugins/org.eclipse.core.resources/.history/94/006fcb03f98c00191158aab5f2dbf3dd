package moigosa;

public class Main {

	public static void main(String[] args) {
		// int[] answer = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		// int[] answer = new int[] { 1, 2, 3, 4, 5 };
		int[] answer = new int[] { 1, 3, 2, 4, 2 };

		for (int data : solution(answer)) {
			System.out.println(data);
		}
	}

	public static int[] solution(int[] answers) {
		int[] answer = {};

		// 1번 수포자의 답지 생성
		int[] answer1 = new int[answers.length];
		for (int i = 0; i < answers.length; i++) {
			answer1[i] = i % 5 + 1;
		}

		// 2번 수포자의 답지 생성
		int[] answer2 = new int[answers.length];
		int count = 1;
		for (int i = 0; i < answers.length; i++) {
			if (i % 2 == 0) {
				answer2[i] = 2;
			} else {
				if (count == 1) {
					answer2[i] = 1;
					count++;
				} else if (count == 2) {
					answer2[i] = 3;
					count++;
				} else if (count == 3) {
					answer2[i] = 4;
					count++;
				} else {
					answer2[i] = 5;
					count = 1;
				}
			}
		}

		// 3번 수포자의 답지 생성
		int[] answer3 = new int[answers.length];
		count = 1;
		for (int i = 0; i < answers.length; i++) {
			if (count == 1 || count == 2) {
				answer3[i] = 3;
				count++;
			} else if (count == 3 || count == 4) {
				answer3[i] = 1;
				count++;
			} else if (count == 5 || count == 6) {
				answer3[i] = 2;
				count++;
			} else if (count == 7 || count == 8) {
				answer3[i] = 4;
				count++;
			} else if (count == 9) {
				answer3[i] = 5;
				count++;
			} else {
				answer3[i] = 5;
				count = 1;
			}
		}
		// 1번 수포자 맞춘갯수
		int correctNum1 = 0;
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == answer1[i]) {
				correctNum1++;
			}
		}
		// 1번 수포자 맞춘갯수
		int correctNum2 = 0;
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == answer2[i]) {
				correctNum2++;
			}
		}
		// 1번 수포자 맞춘갯수
		int correctNum3 = 0;
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == answer3[i]) {
				correctNum3++;
			}
		}
		int[] arr = new int[1];
		arr[0] = correctNum3;

		// 각자 맞춘갯수를 담아두는 배열
		int[] correctEachPerson = new int[3];
		correctEachPerson[0] = correctNum1;
		correctEachPerson[1] = correctNum2;
		correctEachPerson[2] = correctNum3;

		// 맥스값을 찾기
		int max = correctEachPerson[0];
		for (int i = 1; i < 3; i++) {
			if (correctEachPerson[i] > max) {
				max = correctEachPerson[i];
			}
		}

		// 맥스값인 수포자 몇명인지 찾기
		int cnt = 0;
		if (correctEachPerson[0] == max) {
			cnt++;
		}
		if (correctEachPerson[1] == max) {
			cnt++;
		}
		if (correctEachPerson[2] == max) {
			cnt++;
		}
		// 맥스값인 수포자 배열에 넣기
		int[] ary = new int[cnt];
		int flag = 0;
		if (correctEachPerson[0] == max) {
			if (flag == 0) {
				ary[0] = 1;
				flag++;
			} else if (flag == 1) {
				ary[1] = 1;
				flag++;
			} else
				ary[2] = 1;
		}
		if (correctEachPerson[1] == max) {
			if (flag == 0) {
				ary[0] = 2;
				flag++;
			} else if (flag == 1) {
				ary[1] = 2;
				flag++;
			}
			else
				ary[2] = 2;

		}
		if (correctEachPerson[2] == max) {
			if (flag == 0) {
				ary[0] = 3;
			}else if (flag == 1) {
				ary[1] = 3;
				flag++;
			}
			else
				ary[2] = 3;
		}

		return ary;
	}
}
