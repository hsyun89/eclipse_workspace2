package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SearchEmp {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
		Scanner sc = new Scanner(System.in);
		String quest = null;

		while (true) {
			int count = 0;
			System.out.println("������ �̸��� �Է��Ͻÿ� or ����");
			quest = sc.next();
			if (quest.equals("����"))
				break;
			else {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(
						"select ename, to_char(hiredate,'yyyy\"��\"mm\"��\"' ) hiredate,deptno from emp where ename = upper('"
								+ quest + "')");
				while (rs.next()) {
					System.out.println(rs.getString("ename") + "������ �ٹ��� �Դϴ�.");
					System.out.print(rs.getString("hiredate") + "�� �Ի��߰� ����");
					System.out.println(rs.getString("deptno") + "�μ����� �ٹ��ϰ� �ֽ��ϴ�.");
					count++;
				}
				if (count == 0) {
					System.out.println(quest + "������ �ٹ����� �ʽ��ϴ�.");
				}
				rs.close();
			}
		}
		sc.close();
	}

}