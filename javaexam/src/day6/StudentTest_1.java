package day6;

class Student2 {
	String name;
	String project;
	int age;

	void study() {
		System.out.println(name + " 학생이 " + project + " 을 학습합니다.");
	}

	String getStudentInfo() {
		return "이름" +name+ "나이"+age;  //printf형식은 리턴값이 여러개라 안되는듯!
	}
	}

public class StudentTest_1 {
	public static void main(String[] args) {
		Student2 st1 = new Student2();
		st1.name="둘리";
		st1.project="수학";
		st1.age=10;
		st1.study();
		System.out.println(st1.getStudentInfo());
		Student2 st2 = new Student2();
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
