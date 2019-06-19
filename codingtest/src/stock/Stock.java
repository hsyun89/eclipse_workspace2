package stock;

public class Stock {

	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 2, 3 };
		for (int data : solution(prices)) {
			System.out.println(data);
		}
	}

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i+1; j < prices.length; j++) {
				if(prices[j]>=prices[i]) {
					answer[i]+=1;;
				}else {
					answer[i]+=1;;
					break;
				}
			}
		}
		//prices[prices.length-1]=0;
		return answer;
	}
}
