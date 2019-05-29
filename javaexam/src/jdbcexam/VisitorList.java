package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VisitorList {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//드라이버, 없으면 찾아서 빌드패스에 추가해줘야함
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest", "jdbctest");
		//jdbc:DB서버이름:thin드라이버@주소:포트:이름, 아이디, 비번
		Statement stmt = conn.createStatement();
		String sql = "select name, writedate, memo from visitor";
		//;를 자바에서는 빼야함
		ResultSet rs=stmt.executeQuery(sql);
		//ResultSet 결과값을 받는 객체
		//executeQuery 셀렉트문을 사용할 때 쓰는 메소드
		System.out.println(conn.getClass().getName());
		System.out.println(stmt.getClass().getName());
		System.out.println(rs.getClass().getName());
		while(rs.next()) {
			System.out.print(rs.getString("name"));
			System.out.print(rs.getString("writedate"));
			System.out.println(rs.getString("memo"));
		}
		rs.close();
		stmt.close();
		conn.close();
	}
}
