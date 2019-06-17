package core;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/basket1_teach")
public class BasketServlet1_teach extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 현재시간을 구해서 로그 파일에 저장
		response.setContentType("application/json; charset=utf-8");
		String pid = request.getParameter("pid");
		PrintWriter out = response.getWriter();
		String jsonStr = "{ \"pid\" : \""+pid+"\" }";
		out.print(jsonStr);
		out.close();		
	}	

}
