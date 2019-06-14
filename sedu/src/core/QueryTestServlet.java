package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/querytest")
public class QueryTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String[] hobby = request.getParameterValues("hobby");
		String color = request.getParameter("color");
		String[] food = request.getParameterValues("food");
		String memo = request.getParameter("memo");
		String s1 = request.getParameter("s1");
		String s2 = request.getParameter("s2");
		// int num = Integer.parseInt(request.getParameter("stnum"));

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		out.print("<h2>전달된 내용</h2><hr>");
		out.print("<ul>");
		out.print("<li><h3>이름 : " + name + "</h3></li>");
		out.print("<li><h3>암호 : " + pass + "</h3></li>");
		out.print("<li><h3>나이 : " + age + "</h3></li>");
		out.print("<li><h3>성별 : " + sex + "</h3></li>");
		// 취미여러개뽑기
		if (hobby == null) {
			out.print("<li><h3>좋아하는 취미 : 없음</h3></li>");
		} else {
			if (hobby.length == 1) {
				out.print("<li><h3>좋아하는 취미 : " + hobby[0] + "</h3></li>");
			} else {
				for (int i = 0; i < hobby.length; i++)
					if (i == 0) {
						out.print("<li><h3>좋아하는 취미 : " + hobby[0]);
					} else if (i == hobby.length - 1) {
						out.print(", " + hobby[i] + "</h3></li>");
					} else
						out.print(", " + hobby[i]);
			}
		}
		
		//좋아하는 색
		if (color.equals("")) {
			out.print("<li><h3>좋아하는 색 : 없음</h3></li>");
		}else {
			out.print("<li><h3>좋아하는 색 : " + color + "</h3></li>");
		}

		// 음식여러개뽑기
		if (food == null) {
			out.print("<li><h3>좋아하는 음식 : 없음</h3></li>");
		} else {
			if (food.length == 1) {
				out.print("<li><h3>좋아하는 음식 : " + food[0] + "</h3></li>");
			} else {
				for (int i = 0; i < food.length; i++)
					if (i == 0) {
						out.print("<li><h3>좋아하는 음식 : " + food[0]);
					} else if (i == food.length - 1) {
						out.print(", " + food[i] + "</h3></li>");
					} else
						out.print(", " + food[i]);
			}
		}
		out.print("<li><h3><pre>의견 : " + memo + "</pre></h3></li>");
		out.print("<li><h3>비밀1 : " + s1 + "</h3></li>");
		out.print("<li><h3>비밀2 : " + s2 + "</h3></li>");
		out.print("</ul>");

		out.close();
	}
}
