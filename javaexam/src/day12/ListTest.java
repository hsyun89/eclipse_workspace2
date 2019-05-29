package day12;

import java.util.ArrayList;

public class ListTest {

	public static void main(String[] args) {
		int array[] = { 3, 4, 2, 5, 2, 3, 6, 7, 5, 7, 9 };
		CreateList list = new CreateList();
		
		//비효율적
//		for (int i = 0; i < array.length; i++) {
//			Integer data = list.convertList(array).get(i);
//			System.out.println(data);
//		}
		
		//효율적
		ArrayList<Integer> arr = list.convertList(array);
		for (int data : arr) {
			System.out.println(data);
		}

	}

}
