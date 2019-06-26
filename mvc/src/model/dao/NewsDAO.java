package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.NewsVO;

public class NewsDAO {
	private Connection connectDB() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest", "jdbctest");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	private void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (conn != null)
				conn.close();
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public boolean insert(NewsVO vo) {
		boolean result = true;
		try {
			Connection conn = connectDB();
			PreparedStatement pstmt = conn.prepareStatement(
					"insert into news(id, writer, title, content, writedate, cnt) values(NEWS_SEQ.nextval, ?, ?, ?, sysdate, 0)");
			ResultSet rs = null;
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
			close(conn, pstmt, rs);
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	public boolean update(NewsVO vo) {
		boolean result = true;
		try {
			Connection conn = connectDB();
			PreparedStatement pstmt = conn.prepareStatement(
					"update news set writer =?, title =?, content = ?, writedate = sysdate, cnt = ? where id = ?");
			ResultSet rs = null;

			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getCnt());
			pstmt.setInt(5, vo.getId());
			pstmt.executeUpdate();
			close(conn, pstmt, rs);
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	public boolean delete(int id) {
		boolean result = true;
		try {
			Connection conn = connectDB();
			PreparedStatement pstmt = conn.prepareStatement("delete from news where id = ?");
			ResultSet rs = null;
			pstmt.setInt(1, id);
			int deleteNum = pstmt.executeUpdate();
			close(conn, pstmt, rs);
			if (deleteNum != 1)
				result = false;
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	public List<NewsVO> listAll() {
		ArrayList<NewsVO> list = new ArrayList<>();
		try {
			Connection conn = connectDB();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select id, writer, title, content, to_char(writedate, 'yyyy-mm-dd'), cnt from news");
			NewsVO vo;
			while (rs.next()) {
				vo = new NewsVO();
				vo.setId(rs.getInt(1));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setWritedate(rs.getString(5));
				vo.setCnt(rs.getInt(6));
				list.add(vo);
			}
			close(conn, stmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public NewsVO listOne(int id) {
		try {
			Connection conn = connectDB();
			PreparedStatement pstmt = conn.prepareStatement(
					"select id, writer, title, content, to_char(writedate, 'yyyy-mm-dd'), cnt from news where id = ?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs != null) {
				NewsVO vo;
				while (rs.next()) {
					vo = new NewsVO();
					vo.setId(rs.getInt(1));
					vo.setWriter(rs.getString(2));
					vo.setTitle(rs.getString(3));
					vo.setContent(rs.getString(4));
					vo.setWritedate(rs.getString(5));
					vo.setCnt(rs.getInt(6));
					//조회수 올리기
					PreparedStatement pstmt2 = conn.prepareStatement(
							"update news set writer =?, title =?, content = ?, writedate = sysdate, cnt = ? where id = ?");
					pstmt2.setString(1, vo.getWriter());
					pstmt2.setString(2, vo.getTitle());
					pstmt2.setString(3, vo.getContent());
					pstmt2.setInt(4, vo.getCnt()+1);
					pstmt2.setInt(5, vo.getId());
					pstmt2.executeQuery();
					
					return vo;
				}
			}
			close(conn, pstmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
