package day11;

import java.util.LinkedList;

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

public class FriendTestLinkedList {
	public static void main(String[] args) {
      //링크드리스트 추가
		LinkedList<Friend> list = new LinkedList<Friend>();
        list.add(new Friend("apple", "01033532222", "djdjdj@naver.com"));            
        list.add(new Friend("banana", "01033444454", "asdfkjh11@naver.com"));            
        list.add(new Friend("candy", "01012345678", "djdsdfgj@naver.com"));            
        list.add(new Friend("double", "01022453345", "123safd@naver.com"));            
        list.add(new Friend("ee!", "01044127898", "aasdfw@naver.com"));            
		//추가
		System.out.println("이름\t전화번호\t\t이메일");
		System.out.println("----------------------------------------");
//		for (int i = 0; i < fArr.length; i++)
//			System.out.println(fArr[i].getInfo());
//		for (Friend data : fArr)
//			System.out.println(data.getInfo());
		for (Friend data:list)
			System.out.println(data.getInfo());
	}
}
