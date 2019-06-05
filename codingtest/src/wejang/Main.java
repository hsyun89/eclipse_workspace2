package wejang;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {

		String[][] input = new String[][] { { " yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		System.out.println(solution(input));
	}

	public static String solution(String[][] clothes) {
		String answer = "";
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		String clot;
		for(int i = 0 ; i < clothes.length; i++) {
			clot = clothes[i][1];
			if(!hm.containsKey(clot))
				hm.put(clothes[i][1], 1);
			else
				hm.put(key, )
		}



		return answer;
	}

}
