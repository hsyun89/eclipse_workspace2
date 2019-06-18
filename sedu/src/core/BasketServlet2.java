package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/basket2")
public class BasketServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// pid받기
		String pid = request.getParameter("pid");
		// 필요한거 선언
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		// 세션
		HttpSession session = request.getSession();  //세션객체 준비, 이미 있으면 가져옴, 없는데 만들지는 않는다.
		if (session.getAttribute("data") == null)
			session.setAttribute("data", new int[10]);
		int[] data = (int[]) session.getAttribute("data");  //세션에 준비된 배열의 주소값을 가져감

		// 삭제인경우
		if (pid.equals("remove")) {
			session.invalidate();
			out.print("상품이 삭제되었습니다.<br>");
			out.print("<a href= http://70.12.113.172:8000/sedu/html/productlog2.html >상품선택화면 </a>");
		} else {
			for (int i = 0; i < 9; i++) {
				if (pid.equals("p00" + (i + 1))) {
					data[i] += 1;
				}
			}
			if (pid.equals("p010")) {
				data[9] += 1;
			}

			// 출력
			out.print("<h2>선택한 상품 리스트</h2><hr>");
			for (int i = 0; i < 9; i++) {
				if (data[i] != 0) {
					out.print("<ul><li>p00" + (i + 1) + "상품 " + data[i] + "개</li></ul>");
				}
			}
			if (data[9] != 0) {
				out.print("<ul><li>p010상품 " + data[9] + "개</li></ul>");
			}
			//out.print("<a href= http://70.12.113.172:8000/sedu/html/productlog2.html >상품선택화면</a>");
			out.print("<a href= "+request.getHeader("referer")+" >상품선택화면</a>");
			out.print("&nbsp&nbsp&nbsp&nbsp&nbsp");
			out.print("<a href= http://70.12.113.172:8000/sedu/basket2?pid=remove>상품비우기</a>");
		}
		out.close();
	}
}
