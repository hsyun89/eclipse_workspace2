package my.spring.springedu;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@RequestMapping("/calcservlet11")
	public ModelAndView result(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
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
				mav.setViewName("errorResult");
				return mav;
			} else {
				result = num1 / num2;
			}
		}
		request.setAttribute("result", result);
		mav.setViewName("calcResult");
		return mav;
	}
}
