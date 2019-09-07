package kacao;

public class Prob2 {

	public static void main(String[] args) {
		//String p = "(()())()";
		//String p = ")(";
		String p ="()))((()";
		System.out.println(solution(p));
	}

	public static String solution(String p) {
		String answer = "";
		String u = "";
		String v = "";
		if (p == "") { // 1단계
			return "";
		}
		// 2단계
		int flag = 0;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(')
				flag++;
			else
				flag--;
			if (flag == 0) {
				u = p.substring(0, i + 1);
				v = p.substring(i + 1);
				break;
			}
		}
		//3단계 u가 올바른일때
		flag=0;
		int clear=0; //클리어0이면 올바른 1이면 ㄴㄴ
		for(int i=0; i<u.length();i++) {
			if (u.charAt(i) == '(')
				flag++;
			else
				flag--;
			if(flag<0) {
				clear=1;
				break;
			}
		}
		String make="";
		String make2="";
		String make3="";
		if(clear==0) {
			return u+solution(v);
		}else {			//4단계 u가 안올바름
			make="("+solution(v)+")";  //4-1,4-2,4-3
			if(u.length()>2) {
				make2=u.substring(1, u.length()-1);
			
				for(int i=0 ; i<make2.length();i++) {
					if(make2.charAt(i)==')')
						make3+="(";
					else
						make3+=")";
				}
			}
			answer=make+make2+make3;
			return answer;
		}
	}
}
