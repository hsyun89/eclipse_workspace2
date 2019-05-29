package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateTable {
	public static void main(String[] args) throws Exception {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest",
					"jdbctest");
			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE product set balance=100 where id = ?");
			pstmt.setString(1,args[0]);
			int update_su=pstmt.executeUpdate();
			System.out.println("수정된 레코드 수 : "+update_su);
			System.out.println("상품번호가"+args[0]+"인 상품의 balance 필드 수정완료");
			pstmt.close();
			conn.close();

	}
}
