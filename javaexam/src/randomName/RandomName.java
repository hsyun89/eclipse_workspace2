package randomName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomName {

	public static void main(String[] args) throws InterruptedException {
		List<String> list = new ArrayList<String>();
		list.add("강다영");
		list.add("강보성");
		list.add("경현");
		list.add("고경준");
		list.add("고예성");
		list.add("김소미");
		list.add("김유정");
		list.add("박건호");
		list.add("박찬우");
		list.add("설동재");
		list.add("오현경");
		list.add("윤현수");
		list.add("이경준");
		list.add("이민우");
		list.add("이영걸");
		list.add("이정규");
		list.add("전지나");
		list.add("정승명");
		list.add("채민현학");
		list.add("최영선");
		list.add("호유송");
		list.add("홍성재");
		Collections.shuffle(list); // 셔플~
		list.add(20, "null");
		list.add(21, "한수용");

		System.out.println("----------------------앞----------------------");
		for(int i =0; i<4; i++) {
			for(int j =0; j<6; j++) {
			System.out.print(list.get(i*6+j)+"\t");
			Thread.sleep(500);
//			if ((i*6+j)%2==1)
//				System.out.print(" | ");
			}
			System.out.println();
		}
		System.out.println("----------------------뒤----------------------");
	}
	
}

