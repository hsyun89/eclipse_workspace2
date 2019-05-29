package day6;

class Student {
	String name;
	String project;
	int age;

	void study() {
		System.out.println(name + " 학생이 " + project + " 을 학습합니다.");
	}

	String getStudentInfo() {
		return "이름 : " + name + "나이" + age;
	}
}

public class StudentTest {
	public static void main(String[] args) {
		Student st1 = new Student();
		st1.name="둘리";
		st1.project="수학";
		st1.age=10;
		st1.study();
		System.out.println(st1.getStudentInfo());
		Student st2 = new Student();
		st2.name="듀크";
		st2.project="과학";
		st2.age=24;
		st2.study();
		System.out.println(st2.getStudentInfo());
		System.out.println(st1);
		System.out.println(st2);
		st1=st2;
		System.out.println("st1=st2 수행한 후");
		System.out.println(st1);
		System.out.println(st2);
		System.out.println(st1.name);
		System.out.println(st2.name);
	}
}
