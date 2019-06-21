package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.vo.ProductVO;

@WebServlet("/productservlet1")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid=request.getParameter("pid");		
		HttpSession session = request.getSession();
		if(session.getAttribute("data")==null)
			session.setAttribute("data", new ProductVO());
		
		ProductVO vo=(ProductVO) session.getAttribute("data");
		
		if(pid.equals("remove")) {
			session.invalidate();
			request.getRequestDispatcher("/jspexam/productView2.jsp").forward(request, response);
			return; //리턴을 해줘야 여기서 끝난다.
		}else{
			
			if(pid.equals("p001")) {
				vo.setApple();
			}
			else if(pid.equals("p002")) {
				vo.setBanana();
			}
			else if(pid.equals("p003")) {
				vo.setHalabong();
			}
			request.setAttribute("data", vo);
			request.getRequestDispatcher("/jspexam/productView.jsp").forward(request, response);
		}
	}
}
