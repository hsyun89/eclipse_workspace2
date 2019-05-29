package jdbcexam;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class ConnectDB {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//드라이버, 없으면 찾아서 빌드패스에 추가해줘야함
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest", "jdbctest");
		//jdbc:DB서버이름:thin드라이버@주소:포트:이름, 아이디, 비번
		System.out.println(conn.getClass().getName()); //클래스 이름 추출
		DatabaseMetaData mdata = conn.getMetaData();
		System.out.println(mdata.getClass().getName()); //클래스 이름 추출
		System.out.println("접속된 DB 서버 : " + mdata.getDatabaseProductName());
		conn.close();
	}
}
