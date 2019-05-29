package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VisitorList2 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 드라이버, 없으면 찾아서 빌드패스에 추가해줘야함
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest", "jdbctest");
			// jdbc:DB서버이름:thin드라이버@주소:포트:이름, 아이디, 비번
			stmt = conn.createStatement();
			String sql = "select name, writedate, memo from visitor";
			// ;를 자바에서는 빼야함
			rs = stmt.executeQuery(sql);
			// ResultSet 결과값을 받는 객체
			// executeQuery 셀렉트문을 사용할 때 쓰는 메소드
			while (rs.next()) {
				System.out.print(rs.getString("name"));
				System.out.print(rs.getString("writedate"));
				System.out.println(rs.getString("memo"));
			}
		} catch (Exception e) {
			System.err.println("오류발생" + e);
		} finally {
			try {
				//DB서버 오류나면 객체 생성자체가 안될 수 있음
				//생성이 안되었는데 닫을수는 없으므로 if문을 넣어줌
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
