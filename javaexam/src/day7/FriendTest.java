package day7;

//부모, 사람 클래스
class Person {
	private String name;

	Person(String name) {
		this.name = name;
	}

	public String getInfo() {
		return name;
	}
}

// 자식, 친구 클래스
class Friend extends Person {
	private String phoneNum;
	private String email;

	Friend(String name, String phoneNum, String email) {
		super(name);
		this.phoneNum = phoneNum;
		this.email = email;
	}

	public String getInfo() {
		return super.getInfo() + "\t" + phoneNum + "\t" + email;
	}
}

public class FriendTest {
	public static void main(String[] args) {
		Friend fArr[] = new Friend[5];
		fArr[0] = new Friend("apple", "01033532222", "djdjdj@naver.com");
		fArr[1] = new Friend("banana", "01033444454", "asdfkjh11@naver.com");
		fArr[2] = new Friend("candy", "01012345678", "djdsdfgj@naver.com");
		fArr[3] = new Friend("double", "01022453345", "123safd@naver.com");
		fArr[4] = new Friend("ee!", "01044127898", "aasdfw@naver.com");
		System.out.println("이름\t전화번호\t\t이메일");
		System.out.println("----------------------------------------");
//		for (int i = 0; i < fArr.length; i++)
//			System.out.println(fArr[i].getInfo());
		for (Friend data : fArr)
			System.out.println(data.getInfo());
	}
}
