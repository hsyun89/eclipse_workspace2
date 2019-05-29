package day6;

class Member{
	String name;
	String account;
	String passwd;
	int birthYear;
}

public class MemberTest1 {
	public static void main(String[] args) {
		Member mem1 = new Member();
		mem1.name = "À±Çö¼ö";
		mem1.account = "hsyun89";
		mem1.passwd = "12345678";
		mem1.birthYear = 891031;
		System.out.printf("È¸¿ø1 : %s(%s, %s, %d)\n"
				,mem1.name,mem1.account,
				mem1.passwd,mem1.birthYear);
		
		Member mem2 = new Member();
		mem2.name = "±è¶Ê¶Ê";
		mem2.account = "asdfkjhw";
		mem2.passwd = "6846351";
		mem2.birthYear = 960544;
		System.out.printf("È¸¿ø2 : %s(%s, %s, %d)\n"
				,mem2.name,mem2.account,
				mem2.passwd,mem2.birthYear);
		
		Member mem3 = new Member();
		mem3.name = "ÀÌ¶Ê¶Ê";
		mem3.account = "leeddol";
		mem3.passwd = "445566";
		mem3.birthYear = 851111;
		System.out.printf("È¸¿ø3 : %s(%s, %s, %d)\n"
				,mem3.name,mem3.account,
				mem3.passwd,mem3.birthYear);

	}
}
