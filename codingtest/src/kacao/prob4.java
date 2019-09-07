package kacao;

public class prob4 {

	public static void main(String[] args) {
		String[] words = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
		String[] queries = { "fro??", "????o", "fr???", "fro???", "pro?" };
		for (int data : solution(words, queries))
			System.out.println("앤써" + data);
	}

	public static int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];
		//int[] flag = new int[queries.length]; // 0이면 왼쪽 1이면 오른쪽
		//int[] qLengList = new int[queries.length];
		int leng = 0; // 쿼리 길이
		int qLeng = 0; // 물음표 갯수
		for (int i = 0; i < queries.length; i++) { // 쿼리 하나씩 탐색
			qLeng = 0;
			leng = queries[i].length();
			// 왼쪽 물음표 갯수
			if (queries[i].charAt(0) == '?') {
				for (int k = 0; k < leng; k++) {
					if (queries[i].charAt(k) != '?') {
						break;
					}
					qLeng++;
				}
				for (int p = 0; p < words.length; p++) { //단어 비교하기 반복
					if(leng==words[p].length()) {//길이가 같고
						if(queries[i].substring(qLeng).equals(words[p].substring(qLeng))) { //잘라낸 문자도 같으면
							answer[i]++;
						}
					}
				}
				//flag[i] = 0;
			} else { // 오른쪽 물음표 갯수
				for (int k = leng - 1; k >= 0; k--) {
					if (queries[i].charAt(k) != '?') {
						break;
					}
					qLeng++;
				}				
				for (int p = 0; p < words.length; p++) { //단어 비교하기 반복
					if(leng==words[p].length()) {//길이가 같고
						if(queries[i].substring(0, leng-qLeng).equals(words[p].substring(0, leng-qLeng))) { //잘라낸 문자도 같으면
							answer[i]++;
						}
					}
				}
				//flag[i] = 1;
			}
			//qLengList[i] = qLeng;
			//System.out.println("플래그값" + flag[i]);
			//System.out.println("물음표길이" + qLengList[i]);
		}

		// 비교해서 찾는 과정
//        for(int i=0; i<) {
//        	
//        }

		return answer;
	}
}
