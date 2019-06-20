package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.MemberVO;

@WebServlet("/memberservlet1")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberVO vo = new MemberVO();

		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		if (name.equals("")) {
			vo.setName("없음");
		} else {
			vo.setName(name);
		}

		if (phone.equals("")) {
			vo.setPhone("없음");
		} else {
			vo.setPhone(phone);
		}

		if (id.equals("")) {
			vo.setId("없음");
		} else {
			vo.setId(id);
		}

		if (pass.equals("")) {
			vo.setPass("없음");
		} else {
			vo.setPass(pass);
		}

		System.out.println(vo.getName());
		System.out.println(vo.getPhone());
		System.out.println(vo.getId());
		System.out.println(vo.getPass());
		request.setAttribute("data", vo);
		request.getRequestDispatcher("/jspexam/memberView.jsp").forward(request, response);
	}

}
