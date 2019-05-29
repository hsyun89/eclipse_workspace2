package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class SelectEmp {
	public static void main(String[] args) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
		Statement stmt = conn.createStatement();
		Random random = new Random();
		boolean flag = random.nextBoolean();
		if (flag) {
			ResultSet rs = stmt.executeQuery("SELECT ename, to_char(sal,'999,999') sal from emp");
			while (rs.next()) {
				System.out.print(rs.getString("ename") + "	직원의 월급은");
				System.out.println(rs.getString("sal") + "원입니다.");
			}
			rs.close();
		} 
//		else {
//			ResultSet rs = stmt.executeQuery(
//					"SELECT ename, to_char(hiredate,'yyyy') hiredateY,to_char(hiredate,'mm') hiredateM,to_char(hiredate,'dd') hiredateD from emp");
//			while (rs.next()) {
//				System.out.print(rs.getString("ename") + "	직원은 ");
//				System.out.print(rs.getString("hiredateY") + "년 ");
//				System.out.print(rs.getString("hiredateM") + "월 ");
//				System.out.println(rs.getString("hiredateD") + "일에 입사하였습니다.");
//			}
//			rs.close();
//		}
		
//		else {
//			ResultSet rs = stmt.executeQuery(
//					"SELECT ename, to_char(hiredate,'yyyymmdd') hiredate from emp");
//			while (rs.next()) {
//				System.out.print(rs.getString("ename") + "	직원은 ");
//				String rsString=rs.getString("hiredate");
//				System.out.print(rsString.substring(0,4) + "년 ");
//				System.out.print(rsString.substring(4,6)  + "월 ");
//				System.out.println(rsString.substring(6) + "일에 입사하였습니다.");
//			}
//			rs.close();
//		}
		
		else {
			ResultSet rs = stmt.executeQuery(
					"SELECT ename, to_char(hiredate,'yyyy\"년 \"mm\"월 \"dd\"일\"') hiredate from emp");
			while (rs.next()) {
				System.out.print(rs.getString("ename") + "	직원은 ");
				System.out.println(rs.getString("hiredate") + "에 입사하였습니다.");
			}
			rs.close();
		}
		stmt.close();
		conn.close();
	}
}
