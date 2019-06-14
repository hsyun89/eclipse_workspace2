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

@WebServlet("/myfirst")
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		response.setContentType("text/html; charset=utf-8");

		   String[] weekDay = { "일", "월", "화", "수", "목", "금", "토" };     
		   //Calendar cal = Calendar.getInstance(); 
		   GregorianCalendar cal = new GregorianCalendar();
		      int num = cal.get(Calendar.DAY_OF_WEEK)-1; 
		      String today = weekDay[num]; 
		
		PrintWriter out = response.getWriter();
		out.print("<h2>"+name+"님 반가워요. 오늘은 "+today+"요일입니다!!</h2>");
		
		
	}

}
