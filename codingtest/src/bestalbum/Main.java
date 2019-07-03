package bestalbum;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };
		for (int data : solution(genres, plays)) {
			System.out.println(data);
		}
	}

	public static int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		HashMap<Integer, Integer> hash2 = new HashMap<Integer, Integer>();
		for (int i = 0; i < genres.length; i++) {
			if (hash.containsKey(genres[i])) {
				hash.put(genres[i], plays[i] + hash.get(genres[i]));
			} else {
				hash.put(genres[i], plays[i]);
			}
		}
		ArrayList<Integer> list=new ArrayList<>();
		list.add(hash.putAll(m););
		
		
		int[] answer = {};
		return answer;
	}

}
