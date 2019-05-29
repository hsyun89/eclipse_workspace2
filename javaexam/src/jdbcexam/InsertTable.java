package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTable {
	public static void main(String[] args) throws Exception {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest",
					"jdbctest");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT into product values('00001','10','자바 프로그래밍',50,16500)");
			stmt.executeUpdate("INSERT into product values('00002','10','J2EE 구현 패턴',40,12000)");
			stmt.executeUpdate("INSERT into product values('00003','10','JSP 2.0',60,18000)");
			System.out.println("데이터들을 추가하였습니다.");
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("오류 발생 : " + e);
		}
	}
}
