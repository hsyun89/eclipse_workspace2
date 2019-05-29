package day9;

public class RuntimeTest {

	public static void main(String[] args) throws Exception {
		//런타임 JVM , 런타임 객체의 참조값을 r에 담음
		Runtime r = Runtime.getRuntime();
		
//		Runtime r1 = Runtime.getRuntime();
//		Runtime r2 = Runtime.getRuntime();
//		System.out.println(r);
//		System.out.println(r1);
//		System.out.println(r2);
		r.exec("c:/windows/notepad.exe");
	}

}
