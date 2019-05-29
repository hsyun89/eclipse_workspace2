package day3;

public class ArrayTest5 {

	public static void main(String[] args) {
		int su = (int) (Math.random() * 6) + 5;
		int[] ary = new int[su];
		System.out.println("¹è¿­ÀÇ Å©±â: " + ary.length);
		for (int i = 0; i < ary.length; i++) {
			ary[i] = (int) (Math.random() * 45) + 1;
		}
		for (int data : ary)
			System.out.print(data + " ");
		// ÃÖ´ñ°ª : ÃÖ´ñ°ª = 00
		int max = ary[0];
		for (int data : ary) {
			if(max<data)
				max=data;
		}
		System.out.print("\nÃÖ´ñ°ª = "+max);
		
	}

}
