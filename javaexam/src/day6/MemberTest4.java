package day6;

class Member4 {
	String name;
	String account;
	String passwd;
	private int birthYear;
	
	void setBirthYear(int birthYear) {
		if(birthYear<0)
			return;
		this.birthYear=birthYear;
	}
	int getBirthYear() {
		return birthYear;
	}
}

public class MemberTest4 {
	public static void main(String[] args) {
		Member4 objA[] = new Member4[3];
		objA[0] = new Member4();
		objA[0].name = "À±Çö¼ö";
		objA[0].account = "hsyun89";
		objA[0].passwd = "12345678";
		objA[0].setBirthYear(-891031);
//		System.out.printf("È¸¿ø1 : %s(%s, %s, %d)\n"
//				,objA[0].name,objA[0].account,
//				objA[0].passwd,objA[0].birthYear);

		objA[1] = new Member4();
		objA[1].name = "±è¶Ê¶Ê";
		objA[1].account = "asdfkjhw";
		objA[1].passwd = "6846351";
		objA[1].setBirthYear(960544);
//		System.out.printf("È¸¿ø2 : %s(%s, %s, %d)\n"
//				,objA[1].name,objA[1].account,
//				objA[1].passwd,objA[1].birthYear);

		objA[2] = new Member4();
		objA[2].name = "ÀÌ¶Ê¶Ê";
		objA[2].account = "leeddol";
		objA[2].passwd = "445566";
		objA[2].setBirthYear(851111);
//		System.out.printf("È¸¿ø3 : %s(%s, %s, %d)\n"
//				,objA[2].name,objA[2].account,
//				objA[2].passwd,objA[2].birthYear);

		for (int i = 0; i < objA.length; i++) {
			System.out.printf("È¸¿ø%d : %s(%s, %s, %d)\n", i + 1, objA[i].name, objA[i].account, objA[i].passwd,
					objA[i].getBirthYear());
		}

	}
}
