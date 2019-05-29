package day6;

import java.io.Serializable;

public class Product implements Serializable {
	private String name;
	private int balance;
	private transient int price;  // 직렬화시 제외해라

	// 상품명 셋겟
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	// 재고량 셋겟
	public void setBalance(int balance) {
		if (balance < 0)
			return;
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	// 가격 셋겟
	public void setPrice(int price) {
		if (price < 0)
			return;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	// 생성자 선언
//	Product() {
//		name = "듀크인형";
//		balance = 5;
//		price = 10000;
//	}
	public Product() {
		this("듀크인형", 5, 10000);
	}

	// 겟셋 자동 생성 소스-겟셋
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getBalance() {
//		return balance;
//	}
//
//	public void setBalance(int balance) {
//		this.balance = balance;
//	}
//
//	public int getPrice() {
//		return price;
//	}
//
//	public void setPrice(int price) {
//		this.price = price;
//	}

	public Product(String name, int balance, int price) {
		this.name = name;
		this.balance = balance;
		this.price = price;
	}
}