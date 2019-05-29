package day4;

public class TwoArrayLab3_3{

	public static void main(String[] args) {
		char play[][] = { 
				{ 'X', 'X', 'X', 'R', 'X', 'R'},
				{ 'R', 'X', 'X', 'X', 'X', 'X'},
				{ 'X', 'X', 'R', 'X', 'X', 'X'},
				{ 'R', 'X', 'X', 'F', 'X', 'X'},
				{ 'X', 'R', 'X', 'X', 'X', 'X'},
				{ 'X', 'R', 'X', 'R', 'X', 'R'},
				};
		
		int catchNum = 0;
		int fPosi = 0;
		int fPosj = 0;
		int len = play.length;
		
		// 여우의 위치 
		label: for(int i = 0 ; i < len ; i++) {
			for(int j = 0 ; j < play[i].length ; j++) {
				if(play[i][j] == 'F') {
					fPosi = i + 1;
					fPosj = j + 1;
					break label;
				}
			}
		}
		 
		System.out.println("여우의 위치 : (" + fPosi + "," + fPosj+")");
		
		// 위 아래
		for(char[] i : play) {
			if(i[fPosj-1] == 'R') {
				catchNum++;
			}
		}
		
		// 좌 우
		for(char i : play[fPosi-1]) {
			if(i == 'R') {
				catchNum++;
			}
		}
		
		// 오른쪽 대각선
		for(int i = fPosi ; i < len ; i++) {
			if(play[i][len-i] == 'R' || play[len-i][i] == 'R') {
				catchNum++;
			}
		}
		
		// 왼쪽 대각선
		for(int i = 0 ; i < len ; i++) {
			if(play[i][i] == 'R') {
				catchNum++;
			}
		}
		
		System.out.printf("여우는 토끼를 %d 마리 잡는다.", catchNum);		
	}
}


