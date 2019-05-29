package day13;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CopyExam {

	public static void main(String[] args) {
		GregorianCalendar calendar = new GregorianCalendar();
		int year = calendar.get(Calendar.YEAR);
		int month = (calendar.get(Calendar.MONTH) + 1);
		int date = calendar.get(Calendar.DATE);
		String fileName = year + "_" + month + "_" + date; // 파일 이름 변수

		try (FileReader reader = new FileReader("sample.txt");
				BufferedReader br = new BufferedReader(reader);
				FileWriter writer = new FileWriter("c:/iotest/" + fileName + ".txt", true);
				PrintWriter out = new PrintWriter(writer)) {
			// 읽고 쓰기
			String data;
			while (true) {
				data = br.readLine();
				if (data == null)
					break;
				out.println(data);
//				out.printf("%s%n", data);
			}
			System.out.println("저장 완료되었습니다.");
		} catch (FileNotFoundException fnfe) {
			System.out.println("처리하는 동안 오류가 발생했습니다.");
		} catch (IOException ioe) {
			System.out.println("처리하는 동안 오류가 발생했습니다.");
		}
	}
}
