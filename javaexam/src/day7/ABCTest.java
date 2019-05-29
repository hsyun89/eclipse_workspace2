package day7;
class A{
	A(){
		super();//생략 가능, 없어도 자동으로 됌, 하지만 this가 있으면 없어도 됌
		System.out.println("A클래스의 객체 생성");
	}
}
class B extends A{
	B(int su){
		super();
		System.out.println("B클래스의 객체 생성");
	}
}
class C extends B{
	C(){
		//super(); 조상이 아규먼트가 필요함 
		super(10);
		System.out.println("C클래스의 객체 생성");
	}
}
public class ABCTest {

	public static void main(String[] args) {
		new C();
	}
}
