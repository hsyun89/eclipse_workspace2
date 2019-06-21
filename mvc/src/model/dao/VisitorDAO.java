package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vo.VisitorVO;

public class VisitorDAO {
	public ArrayList<VisitorVO> listAll() {
		ArrayList<VisitorVO> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest",
				"jdbctest");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select name, writedate, memo from visitor");) {
			VisitorVO vo;
			while (rs.next()) {
				vo = new VisitorVO();
				vo.setName(rs.getString(1));
				vo.setWriteDate(rs.getString(2));
				vo.setMemo(rs.getString(3));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<VisitorVO> search(String keyword) {
		return null;
	}

	public boolean insert(VisitorVO vo) {
		return true;
	}
}
