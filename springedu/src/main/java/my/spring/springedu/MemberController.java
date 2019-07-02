package my.spring.springedu;

import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vo.MemberVO;

@Controller
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@RequestMapping("/memberservlet11")
	public ModelAndView proc(MemberVO vo) {
		ModelAndView mav = new ModelAndView();
		String name = vo.getName();
		String phone = vo.getPhone();
		String id = vo.getId();
		String pass = vo.getPass();

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
		mav.addObject("data",vo);
		mav.setViewName("memberView");
		return mav;
	}

}
