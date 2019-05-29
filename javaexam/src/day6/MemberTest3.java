package day6;

class Member3{
	String name;
	String account;
	String passwd;
	int birthYear;
	//생성자 만들기
	Member3(){
		System.out.println("객체 생성");
	}
	// 생성자 오버로딩, 매개변수 사용
	Member3(String name, String account, String passwd, int birthYear){
		this.name=name;
		this.account = account;
		this.passwd = passwd;
		this.birthYear = birthYear;
	}
}

public class MemberTest3 {
	public static void main(String[] args) {
		Member3 objA[] = new Member3[3];
		objA[0] = new Member3("윤현수","hsyun89","123123",891031);  //생성자를 통해 객체 생성
		objA[1] = new Member3("피카츄","pikapika","888888",1);  //생성자를 통해 객체 생성
		objA[2] = new Member3("라이츄","liechuu","77777",1);  //생성자를 통해 객체 생성

		for(int i=0;i<objA.length;i++) {
		System.out.printf("회원%d : %s(%s, %s, %d)\n"
		,i+1,objA[i].name,objA[i].account,
		objA[i].passwd,objA[i].birthYear);
		}
		
	}
}
