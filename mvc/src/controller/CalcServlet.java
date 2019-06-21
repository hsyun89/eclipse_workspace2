package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ProductVO;

@WebServlet("/calcservlet1")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		String oper = request.getParameter("oper");
		int num2 = Integer.parseInt(request.getParameter("num2"));

//		HttpSession session = request.getSession();
//		if (session.getAttribute("result") == null)
//			session.setAttribute("result", new int[1]);
//		int[] result = (int[]) session.getAttribute("result");
		int result;
		if (oper.equals("plus")) {
			result = num1 + num2;
		} else if (oper.equals("minus")) {
			result = num1 - num2;
		} else if (oper.equals("multiple")) {
			result = num1 * num2;
		} else {
			if (num2 == 0) {
				request.setAttribute("result", "<span style=\"color:red\"> 나눗셈 연산시 두 번째 숫자는 0 일 수 없습니다.</span>");
				request.getRequestDispatcher("/jspexam/errorResult.jsp").forward(request, response);
				return;
			} else {
				result = num1 / num2;
			}
		}
		request.setAttribute("result", result);
		request.getRequestDispatcher("/jspexam/calcResult.jsp").forward(request, response);
	}
}
