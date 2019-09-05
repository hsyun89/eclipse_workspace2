package rjava;

import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Repository;

@Repository
public class RTestDAO {

	// 테이블 생성
	public String createTable() {
		String retStr = "";
		RConnection r = null;
		try {
			// R과 연결, 패키지 메모리에 로딩
			r = new RConnection();
			r.eval("library(DBI)");
			r.eval("library(RJDBC)");
			r.eval("library(rJava)");
			r.eval("drv <- JDBC('oracle.jdbc.driver.OracleDriver','C:/HS/ojdbc6.jar')");
			r.eval("conn <- dbConnect(drv, 'jdbc:oracle:thin:@localhost:1521:xe','jdbctest','jdbctest')");
			// 1. 파일 읽기
			r.eval("student<-read.csv('C:/Rstudy/example_studentlist.csv')");
			// 2. dataframe형식으로 oracle에 저장하기
			r.eval("dbWriteTable(conn, 'student', student)");
			System.out.println("테이블 생성과 데이터 저장 성공.......");
			retStr = r.eval("'테이블 생성과 데이터 저장 성공.......'").asString();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			r.close();
		}
		return retStr;
	}

	// 테이블 삭제
	public String dropTable() {
		String retStr = "";
		RConnection r = null;
		try {
			r = new RConnection();
			r.eval("library(DBI)");
			r.eval("library(RJDBC)");
			r.eval("library(rJava)");
			r.eval("drv <- JDBC('oracle.jdbc.driver.OracleDriver','C:/HS/ojdbc6.jar')");
			r.eval("conn <- dbConnect(drv, 'jdbc:oracle:thin:@localhost:1521:xe','jdbctest','jdbctest')");
			r.eval("dbRemoveTable(conn, 'STUDENT')");
			System.out.println("삭제 성공.......");
			retStr = r.eval("'삭제 성공.......'").asString();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			r.close();
		}
		return retStr;
	}

	// 데이터 가져와서 보여주기
	public Object listTable() {
		String retStr = "";
		RConnection r = null;
		try {
			r = new RConnection();
			r.eval("library(DBI)");
			r.eval("library(RJDBC)");
			r.eval("library(rJava)");
			r.eval("drv <- JDBC('oracle.jdbc.driver.OracleDriver','C:/HS/ojdbc6.jar')");
			r.eval("conn <- dbConnect(drv, 'jdbc:oracle:thin:@localhost:1521:xe','jdbctest','jdbctest')");
			//이게 실패
			r.eval("query <- 'SELECT * FROM STUDENT'");
			System.out.println("select success1");
			RList list = r.eval("dbGetQuery(conn,query)").asList();
			System.out.println("select success2");
			int cols = list.size();
			int rows = list.at(0).length();
			String[][] s = new String[cols][];
			for (int i = 0; i < cols; i++) {
				s[i] = list.at(i).asStrings();
			}
			for (int j = 0; j < rows; j++) {
				for (int i = 0; i < cols; i++) {
					retStr += (s[i][j]) + "";
				}
				retStr += "</br>";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			r.close();
		}
		return retStr;
	}

}
