package day11;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class HashMapLab1 {

	public static void main(String[] args) {
		// 선언
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Scanner sc = new Scanner(System.in);
		// 입력 버전1
//		while(map.size()<5) {
//		System.out.print("나라를 입력하세요");
//		String nation = sc.next();
//		System.out.print("인구수를 입력하세요 ");
//		int people = sc.nextInt();
//        map.put(nation,people);
//		}
		// 입력 버전2
		while (map.size() < 5) {
			System.out.print("나라와 인구수를 입력하세요");
			String nation = sc.next();
			int people = sc.nextInt();
			map.put(nation, people);
		}
		sc.close();
		// 출력1
//		System.out.print("입력된 데이터 : ");
//		int i = 0;
//		for (String key : map.keySet()) {
//			int value = map.get(key);
//			if (i == 0) {
//				System.out.print(key + "(" + value + ")");
//				i++;
//			} else
//				System.out.print(", " + key + "(" + value + ")");
			
			//출력2
			System.out.print("입력된 데이터 : ");
			int i = 0;
			Set<String> kset =map.keySet();
			System.out.println(kset.getClass().getName());
			for (String key : kset) {
				int value = map.get(key);
				if (i == 0) {
					System.out.print(key + "(" + value + ")");
					i++;
				} else
					System.out.print(", " + key + "(" + value + ")");
		}
	}
}
