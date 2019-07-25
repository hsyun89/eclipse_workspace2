package trainproj.spring.springtrain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.MemberDAO;
import vo.MemberVO;

@Controller
public class RegisterController {
	@Autowired
	MemberDAO dao;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	  public ModelAndView showRegisterForm() {
	    ModelAndView mav = new ModelAndView("registerView");
	    mav.addObject("registerView", new MemberVO());
	    mav.setViewName("registerView");
	    return mav;
	  }

	@RequestMapping(value = "/registerInsert", method = RequestMethod.POST)
	protected ModelAndView regControl(MemberVO vo, String action) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = null;
		if (vo.getUser_id() != null && vo.getEmail() != null && vo.getPasswd() != null) {
			boolean result = dao.register(vo);
			if (action != null && action.equals("register")) {
				if (result) {
				// 로그인 페이지로 재설정(보내기)
					mav.addObject("msg", vo.getUser_id() + "님 가입을 환영합니다.");
					viewName = "loginView";
				} else {
					mav.addObject("msg", "이미 존재하는 아이디입니다.");
					viewName = "registerView";
				}
			}
		}
		mav.setViewName(viewName);
		return mav;
	}
}
