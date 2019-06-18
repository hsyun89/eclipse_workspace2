package pohneNumberList;

public class PhoneNumberList {

	public static void main(String[] args) {
		//String[] phone_book = { "119", "97674223", "1195524421" };
		String[] phone_book = { "119","0119","0119" };
		System.out.println(solution(phone_book));
	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		int stringLength = 0;
		int flag;
		for (int i = 0; i < phone_book.length; i++) {
			flag = 0;
			stringLength = phone_book[i].length();
			for (int j = 0; j < phone_book.length; j++) {
				if(phone_book[i].length()<=phone_book[j].length()) {//길이가 작거나 같은 경우에만
					
					if (phone_book[i].equals(phone_book[j].substring(0, stringLength))) {
						flag++;
						// 겹치는게 없으면 자신 하나만 올라감 1이 됌
						// 겹치는게 있으면 2이상
					}
					if (flag > 1) { // 겹치는게 있다면
						answer = false;
						return answer;
					}
				}
			}
		}

		return answer;
	}
}
