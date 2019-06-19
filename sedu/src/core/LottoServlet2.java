package core;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lotto2")
public class LottoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int lottoNum=Integer.parseInt(request.getParameter("lottoNum"));
		int rand = (int)(Math.random()*6+1);
		System.out.println("전달된 값 : "+lottoNum+", 추출된 값 : "+rand);
		
		//입력값 전달
		request.setAttribute("lottoNum", lottoNum);
		request.setAttribute("rand", rand);
		String uri="/jspexam/lottoResult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}
}
