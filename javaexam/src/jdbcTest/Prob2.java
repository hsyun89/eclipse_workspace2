package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Prob2 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		kaja("E");
	}

	public static void kaja(String fn) {
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
				PreparedStatement pstmt = conn.prepareStatement(
						"select first_name 이름, last_name 성, to_char(salary,'99,999')||'원' 급여 from employees where first_name like '?%'");
				) {
			pstmt.setString(1, fn+"%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getString("이름"));
				System.out.print("(" + rs.getString("성") + ")");
				System.out.println(rs.getString("급여"));
			}
		} catch (SQLException e) {
			System.out.print("DB연동 오류 발생 : ");
			e.printStackTrace();
		}
	}
}
