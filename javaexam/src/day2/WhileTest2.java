package day2;

public class WhileTest2 {

	public static void main(String[] args) {
		int lottoNum;
		while (true) {
			lottoNum = (int) (Math.random() * 6) + 1;
			if (lottoNum == 3) {
//				System.out.println("雁歎!! せせせ"+lottoNum);
				System.out.printf("雁歎!! せせせ%d\n", lottoNum);
				break;
			} else {
//				System.out.println("仙獣亀!! ばばば"+lottoNum);
				System.out.printf("仙獣亀!! ばばば%d\n", lottoNum);
			}
		}
//		System.out.println("呪楳 曽戟...");
		System.out.printf("呪楳 曽戟...\n");
	}
}
