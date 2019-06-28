package my.spring.springedu;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EduController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@RequestMapping("/eduservlet11")
	public ModelAndView proc(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		int avg = Integer.parseInt(request.getParameter("avg"));
		if (avg >= 90) {
			request.setAttribute("grade", "A");
			mav.setViewName("gradeA");
		} else if (avg >= 80) {
			request.setAttribute("grade", "B");
			mav.setViewName("gradeB");
		} else if (avg >= 70) {
			request.setAttribute("grade", "C");
			mav.setViewName("gradeC");
		}else {
			request.setAttribute("grade", "D");
			mav.setViewName("gradeD");
		}
		return mav;
	}
}
