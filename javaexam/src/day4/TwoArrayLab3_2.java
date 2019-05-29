package day4;

public class TwoArrayLab3_2 {
	public static void main(String[] args) {
		char play[][] = { { 'X', 'X', 'X', 'R', 'X', 'R' }
						  , { 'R', 'X', 'X', 'X', 'X', 'X' }
						  , { 'X', 'X', 'R', 'X', 'X', 'X' }
						  , { 'R', 'X', 'X', 'F', 'X', 'X' }
						  , { 'X', 'R', 'X', 'X', 'X', 'X' }
						   ,{ 'X', 'R', 'X', 'R', 'X', 'R' } };

		int catchNum = 0;
		/*
		 * R은 토끼이고 F는 여우다 여우의 위치는 정해져 있고 정해진 위치에서 대각선과 직선으로만 이동 가능하다. 위와 같은 2차원 배열 데이터에서
		 * 토끼를 몇마리 잡겠는가?
		 */
		int fPosi = 0;
		int fPosj = 0;

		for (int i = 0; i < play.length; i++) {
			for (int j = 0; j < play[i].length; j++) {
				if (play[i][j] == 'F') {
					fPosi = i + 1;
					fPosj = j + 1;
				}
			}
		}

		for (int i = 0; i < play.length; i++) {
			for (int j = 0; j < play[i].length; j++) {
				if ((i == fPosi-1 || j == fPosj-1 || 
					fPosi - fPosj == i-j || fPosi + fPosj -2 == i+j)
						&& play[i][j] == 'R')
					catchNum++;
			}
		}
		// 구현

		System.out.println("여우의 위치 : (" + fPosi + "," + fPosj + ")");

		// 구현

		System.out.printf("여우는 토끼를 %d 마리 잡는다.", catchNum);
	}
}
