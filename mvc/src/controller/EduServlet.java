package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/eduservlet1")
public class EduServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//º¯È¯
		request.setCharacterEncoding("UTF-8");

		int avg = Integer.parseInt(request.getParameter("avg"));
		String uri = "";
		if (avg >= 90) {
			request.setAttribute("grade", "A");
			uri = "/jspexam/gradeA.jsp";
		} else if (avg >= 80) {
			request.setAttribute("grade", "B");
			uri = "/jspexam/gradeB.jsp";
		} else if (avg >= 70) {
			request.setAttribute("grade", "C");
			uri = "/jspexam/gradeC.jsp";
		}else {
			request.setAttribute("grade", "D");
			uri = "/jspexam/gradeD.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}
}
