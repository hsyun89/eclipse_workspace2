package day6;

class Book {
	String title;
	String author;
	int price;
	//생성자
	Book() {
		//this()는 같은 클래스에 있는 다른 생성자를 매개변수에 맞게 호출, #첫 번째 문장이어야 함.
		this("자바의 정석", "남궁성", 30000);
		System.out.println("자바의 정석 객체 생성!!");

//		title="자바의 정석";
//		author="남궁성";
//		price=30000;
	}
	Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}

	String getBookInfo() {
		return "책이름\t" + title + "\t저자\t" + author + "\t가격\t" + price;
	}
}

public class BookTest {
	public static void main(String[] args) {
		Book bookArr[] = new Book[5];
		bookArr[0] = new Book("a", "b", 100);
		bookArr[1] = new Book("c", "d", 200);
		bookArr[2] = new Book("e", "f", 300);
		bookArr[3] = new Book("g", "h", 400);
		bookArr[4] = new Book();
//		b[4].title = "자바의 정석";
//		b[4].author = "남궁성";
//		b[4].price = 30000;

//		for (int i = 0; i < bookArr.length; i++)
//			System.out.println(bookArr[i].getBookInfo());
		for(Book data : bookArr) {
			System.out.println(data.getBookInfo());
		}

	}

}
