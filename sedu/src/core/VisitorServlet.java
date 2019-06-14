package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visitor")
public class VisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		out.print("<h2>" + request.getParameter("name") + "님이" + day() + "에 남긴 글입니다.</h2><hr>");
		out.print("<pre>"+request.getParameter("memo")+"</pre>");
		//줄바꿈도 표현하기
		//out.print("<textarea cols=\"50\" rows=\"20\">"+request.getParameter("memo")+"</textarea>");
		out.print("<br><a href=\"http://localhost:8000/sedu/html/visitorForm.html\">입력화면으로</a>");
		out.close();
	}

	String day() {
		GregorianCalendar cal = new GregorianCalendar();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DATE);
		return year + "년 " + month + "월 " + day + "일";
	}
}
