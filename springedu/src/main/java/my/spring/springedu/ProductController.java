package my.spring.springedu;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vo.ProductVO;

@Controller
public class ProductController {
	@RequestMapping("/productservlet11")
	public ModelAndView proc(String pid, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("data") == null)
			session.setAttribute("data", new ProductVO());

		ProductVO vo = (ProductVO) session.getAttribute("data");
			if (pid.equals("p001")) {
				vo.setApple();
			} else if (pid.equals("p002")) {
				vo.setBanana();
			} else if (pid.equals("p003")) {
				vo.setHalabong();
			}
			mav.addObject("data", vo);
			mav.setViewName("productView");
			return mav;
	}
	@RequestMapping(value = "/remove11", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String lll(HttpSession session) {
		session.invalidate();
		String s = "{\"result\" : \"지워짐~~\"}";
		return s;
	}
}
