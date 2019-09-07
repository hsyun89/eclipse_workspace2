package kacao;

public class Prbo1 {

	public static void main(String[] args) {
		// String s = "aabbaccc";
		//String s = "abcabcx";
		String s = "aaaaaaxbbbbbb";
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		int answer = s.length();
		String zip = "";
		int count = 1;
		// 1개단위
		for (int k = 1; k < s.length()/2+1; k++) {
			for (int i = 0; i < s.length() - k; i += k) {
				//System.out.println(k);
				//System.out.println(count);
				//탈출
				if(i+2*k>s.length()) {
					if(count==1)
						zip+=s.substring(i,s.length());
					else
						zip+=(count + "")+s.substring(i,s.length());
					break;
				}
				
				if (s.substring(i, i + k).equals(s.substring(i + k, i + 2*k))) {
					count++;
				} else {
					if (count > 1) {
						zip += (count + "") + s.substring(i, i + k);
						count = 1;
					} else {
						zip += s.substring(i, i + k);
					}
				}
				if (i == s.length() - (2 * k)) {
					if (count > 1) {
						zip += (count + "") + s.substring(i, i + k);
						count = 1;
					} else {
						zip += s.substring(i + k, i + 2 * k);
					}
				}
			}
			count=1;
			System.out.println(zip);
			if(zip.length()<answer) {
				answer = zip.length();
			}
			//answer = zip.length();
			zip = "";
		}
		return answer;
	}
}

//2단위
//			for (int i = 0; i < s.length() - 2; i +=2) {
//				if (s.substring(i, i + 2).equals(s.substring(i + 2, i + 4))) {
//					count++;
//				} else {
//					if (count > 1) {
//						zip += (count + "") + s.substring(i, i + 2);
//						count = 1;
//					} else {
//						zip += s.substring(i, i + 2);
//					}
//				}
//				if (i == s.length() - 4) {
//					if (count > 1) {
//						zip += (count + "") + s.substring(i, i + 2);
//						count = 1;
//					} else {
//						zip += s.substring(i, i + 2);
//					}
//				}
//			}
//