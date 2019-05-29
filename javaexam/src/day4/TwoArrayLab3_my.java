package day4;

public class TwoArrayLab3_my {
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
		/*
		 * R은 토끼이고 F는 여우다
		 * 여우의 위치는 정해져 있고 
		 * 정해진 위치에서 대각선과 직선으로만 이동 가능하다. 
		 * 위와 같은 2차원 배열 데이터에서
		 * 토끼를 몇마리 잡겠는가?
		 */
		int fPosi = 0;
		int fPosj = 0;
		//여우위치 판독기
		HSY: for(int i =0; i<play.length;i++) {
			for(int j =0; j<play[i].length;j++) {
				if(play[i][j]=='F') {
					fPosi=i;
					fPosj=j;
					break HSY;
				}
			}
		}
		//수평 판독기
		for(int i=0;i<play[fPosi].length;i++) {
			if(play[fPosi][i]=='R')
				catchNum+=1;
		}
		//수직 판독기
		for(int i=0;i<play.length;i++) {
			if(play[i][fPosj]=='R')
				catchNum+=1;
		}
		//우하향 판독
		for(int i=1; true ;i++) {
		if(play[fPosi+i][fPosj+i]=='R') {
			catchNum+=1;
		}
		if(fPosi+i==5 || fPosj+i==5) {
			break;
		}
		}
		//우상향 판독
		for(int i=1; true ;i++) {
		if(play[fPosi-i][fPosj+i]=='R') {
			catchNum+=1;
		}
		if(fPosi-i==0 || fPosj+i==5) {
			break;
		}
		}
		//좌상향 판독
		for(int i=1; true ;i++) {
		if(play[fPosi-i][fPosj-i]=='R') {
			catchNum+=1;
		}
		if(fPosi-i==0 || fPosj-i==0) {
			break;
		}
		}
		//좌하향 판독
		for(int i=1; true ;i++) {
		if(play[fPosi+i][fPosj-i]=='R') {
			catchNum+=1;
		}
		if(fPosi+i==5 || fPosj-i==0) {
			break;
		}
		}
		
		
//		System.out.println(fPosj[3][3]);
		
		System.out.println("여우의 위치 : (" + fPosi + "," + fPosj+")");
		
		// 구현	
		
		System.out.printf("여우는 토끼를 %d 마리 잡는다.", catchNum);		
	}
}


