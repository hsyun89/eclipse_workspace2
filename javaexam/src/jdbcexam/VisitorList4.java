package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VisitorList4 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
//		String sql = "select name, writedate, memo from visitor where name = '유니코'";
		String sql = "select name, writedate, memo from visitor ";

		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest",
				"jdbctest"); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {
			// 추출된 결과가 한 행이라도 존재하면 리스트를 출력하고 없으면 "추출된 행 없음"이라고 출력
			if (rs.next()) {
				do {
					System.out.print(rs.getString("name"));
					System.out.print(rs.getString("writedate"));
					System.out.println(rs.getString("memo"));
				} while (rs.next());
			} else
				System.out.println("추출된 행 없음");

		} catch (Exception e) {
			System.err.println("오류발생" + e);
		}
	}
}
