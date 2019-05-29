package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteTable {
	public static void main(String[] args) throws Exception {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest",
					"jdbctest");
			PreparedStatement pstmt = conn.prepareStatement(
					"DELETE from product where balance < ?");
			pstmt.setInt(1,Integer.parseInt(args[0]));
			int del_su=pstmt.executeUpdate();
			System.out.println("재고가"+args[0]+"이하인 상품 정보를"+del_su+"개 삭제하였습니다.");
			pstmt.close();
			conn.close();

	}
}
