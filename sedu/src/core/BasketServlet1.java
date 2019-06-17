package core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/basket1")
public class BasketServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		String pid = request.getParameter("pid");
		PrintWriter out = response.getWriter();
		out.print("{\"pid\":\""+pid+"\"}");
		out.close();
		
		
		String path = "C:/longtest";
		File dir = new File(path);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		try(FileWriter writer = new FileWriter("C:/longtest/mylog.txt", true);
				PrintWriter outFile = new PrintWriter(writer);) {
			Date today = new Date();
			SimpleDateFormat format1 =new SimpleDateFormat("yyyyMMddmmss");
			outFile.print(format1.format(today));
			outFile.println(" "+pid);
		} catch(Exception e) {
			System.out.println("파일에 저장하는 동안 오류가 발생했습니다.");
		}
		
		
	}
}
