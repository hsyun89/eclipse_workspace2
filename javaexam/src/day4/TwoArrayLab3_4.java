package day4;

public class TwoArrayLab3_4 {

	public static void main(String[] args) {
		char play[][] = { { 'X', 'X', 'X', 'R', 'X', 'R' }, { 'R', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', 'X', 'R', 'X', 'X', 'X' }, { 'R', 'X', 'X', 'F', 'X', 'X' }, { 'X', 'R', 'X', 'X', 'X', 'X' },
				{ 'X', 'R', 'X', 'R', 'X', 'R' }, };

		int catchNum = 0;
		int foxX = 0;
		int foxY = 0;

		A: for (int x = 0; x < play.length; x++) {
			for (int y = 0; y < play[x].length; y++) {
				if (play[x][y] == 'F') {
					foxX = x;
					foxY = y;
					break A;
				}
			}
		}

		for (int x = 0; x < play.length; x++) {
			for (int y = 0; y < play[x].length; y++) {
				if (x == foxX) {
					if (play[x][y] == 'R')
						catchNum++;
				} else {
					if (y == foxY) {
						if (play[x][y] == 'R') {
							catchNum++;
						}
					} else {
						if ((Math.abs(foxX - x) == Math.abs(foxY - y)) && play[x][y] == 'R')
							catchNum++;
					}
				}
			}
		}
		System.out.printf("여우는 토끼를 %d 마리 잡는다.", catchNum);
	}
}
