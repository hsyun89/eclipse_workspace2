package day11;

import java.util.HashSet;

public class LottoSet {

	public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<Integer>();
        while(set.size()<10)
        set.add((int)(Math.random()*21)+10);
        
//        for(Integer data:set) {
//        	System.out.println(data);
//	}
    	System.out.print("오늘의 로또 번호 : ");
        System.out.println(set/*.toString()*/);

}
}