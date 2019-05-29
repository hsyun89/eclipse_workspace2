package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchEmp2 {

	public static void main(String[] args) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
		Scanner sc = new Scanner(System.in);
		String request = null;
		PreparedStatement pstmt = conn
				.prepareStatement("select ename from emp e, dept d where e.deptno = d.deptno and dname=?");
		PreparedStatement pstmt2 = conn.prepareStatement("select dname from dept where dname=?");

		while (true) { // 무한루프
			System.out.println("부서명 or 종료");
			request = sc.next(); // 입력받기
			if (request.equals("종료")) { // 종료여부
				break;
			} else {
				pstmt2.setString(1, request); // 1부서이름을 먼저 받음
				if (pstmt2.executeUpdate() != 0) { // 1-1존재하는 부서이름이라면
					pstmt.setString(1, request); // 2부서에 있는 직원이름 받기
					if (pstmt.executeUpdate() != 0) { // 2-1직원이 한명이상 존재하면 출력~
						ResultSet rs = pstmt.executeQuery();
						System.out.println(request + " 부서에서 근무하는 직원들");
						while (rs.next()) {
							System.out.println(rs.getString("ename"));
						}
					} else { // 2-2직원이 한명도 없다면
						System.out.println(request + "부서에서 근무하는 직원이 없습니다.");
					}
				} else { // 1-2 존재하지 않는 부서를 입력했다면
					System.out.println(request + " 부서는 없습니다.");
				}
			}
		}
		sc.close();
	}
}
