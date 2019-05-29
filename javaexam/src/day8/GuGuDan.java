package day8;

import java.util.Date;

import day5.MethodLab3; //컨트롤+쉬프트+O 자동 임포트

//import day5.MethodLab3;
//import java.*;
//부모클래스
class Multiplication {
	private int dan;
	private int number;

	Multiplication() {
	}

	Multiplication(int dan) {
		this.dan = dan;
	}

	Multiplication(int dan, int number) {
		this.dan = dan;
		this.number = number;
	}

	void printPart() {
		if (number == 0) {
			for (int n = 1; n <= 9; n++)
				System.out.print("\t" + dan + "*" + n + "=" + dan * n);
			System.out.println();
		} else {
			System.out.println(dan * number);
		}
	}
}

//자식 클래스
class GuGuDanExpr extends Multiplication {
	GuGuDanExpr() {
	}

	GuGuDanExpr(int dan) {
		super(dan);
	}

	GuGuDanExpr(int dan, int number) {
		super(dan, number);
	}

	void printPart() {
		super.printPart();
	}

	public static void printAll() {
		for (int n = 1; n <= 9; n++) {
			for (int k = 1; k <= 9; k++) {
				System.out.print("\t" + k + "*" + k + "=" + k * n);
			}
			System.out.println();
		}
	}
}

//메인 클래스
public class GuGuDan {
	public static void main(String[] args) {
		int dan = MethodLab3.getRandom(1, 20); //import사용
		int number = day5.MethodLab3.getRandom(1, 20); //그냥 부르기

		GuGuDanExpr gugu = null;
		// 1번경우
		if (dan < 10 && number < 10) {
			gugu = new GuGuDanExpr(dan, number);
			System.out.print(dan + " * " + number + " = ");
			gugu.printPart();
		}
		// 2번경우
		else if (dan < 10 && number > 9) {
			gugu = new GuGuDanExpr(dan);
			System.out.print(dan + " 단 : ");
			gugu.printPart();
		}
		// 3번경우
		else {
//			GuGuDanExpr gugu=new GuGuDanExpr(dan);
			GuGuDanExpr.printAll(); // static
		}
		Date d = new Date();
		System.out.println("오늘은 "+d.getDate()+"일입니다.");
		System.out.println("오늘은 "+d+"일입니다.");
		System.out.println("오늘은 "+d.getTime()+"일입니다.");
	}
}
