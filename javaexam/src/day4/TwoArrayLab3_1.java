package day4;

public class TwoArrayLab3_1 {

	public static void main(String[] args) {
		char play[][] = { { 'X', 'X', 'X', 'R', 'X', 'R' }, { 'R', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', 'X', 'R', 'X', 'X', 'X' }, { 'R', 'X', 'X', 'F', 'X', 'X' }, { 'X', 'R', 'X', 'X', 'X', 'X' },
				{ 'X', 'R', 'X', 'R', 'X', 'R' } };

		int catchNum = 0;
		/*
		 * R은 토끼이고 F는 여우다 여우의 위치는 정해져 있고 정해진 위치에서 대각선과 직선으로만 이동 가능하다. 위와 같은 2차원 배열 데이터에서
		 * 토끼를 몇마리 잡겠는가?
		 */
		int fPosi = 0;
		int fPosj = 0;

		// 구현
		// 여우의 위치를 구하는 것
		find: for (int i = 0; i < play.length; i++) {
			for (int j = 0; j < play[i].length; j++) {
				if (play[i][j] == 'F') {
					fPosi = i;
					fPosj = j;
					break find;
				}
			}			
		}

		System.out.println("여우의 위치 : (" + fPosi + "," + fPosj + ")");

		for (int i = 0; i < play[fPosi].length; i++) {
			if (play[fPosi][i] == 'R')
				catchNum++;
		} // 가로로 잡는

		for (int i = 0; i < play.length; i++) {
			if (play[i][fPosj] == 'R')
				catchNum++;
		} // 세로로 잡는

		//int i = fPosi;
		//int j = fPosj;

		for (int i = fPosi, j = fPosj;
			i < play.length && j < play[i].length; i++,j++) {
			if (play[i][j] == 'R')
				catchNum++;			
		} // 왼쪽대각선 아래방향으로

		int i = fPosi;
		int j = fPosj;

		while (i > -1 && j > -1) {
			if (play[i][j] == 'R')
				catchNum++;
			i--;
			j--;
		} // 왼쪽대각선 윗 방향으로

		i = fPosi;
		j = fPosj;

		while (i < play.length || j > 0) {
			if (play[i][j] == 'R')
				catchNum++;
			i++;
			j--;
		} // 오른쪽대각선 아래방향으로

		i = fPosi;
		j = fPosj;

		while (i > 0 || j < play.length) {
			if (play[i][j] == 'R')
				catchNum++;
			i--;
			j++;
		} // 오른쪽대각선 윗방향으로
		System.out.printf("여우는 토끼를 %d 마리 잡는다.", catchNum);
	}
}
