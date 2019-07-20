package trainproj.spring.springtrain;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.MemberDAO;
import dao.PartyDAO;
import vo.MemberVO;
import vo.PartyVO;

@Controller
public class LoginController {
	@Autowired
	MemberDAO memberDAO;
	PartyDAO partyDAO;

// 추가 사항
// 로그인 get방식으로 받은것을 저장
// 출력하지 않음
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	  protected ModelAndView showLogin(HttpSession session) {
		System.out.println("시작");
	    ModelAndView mav = new ModelAndView("loginView");
	    System.out.println("뷰 셋업");
	    mav.addObject("loginView", new MemberVO());
	    System.out.println("로그인 페이지 로딩 끝");
	    String login_id = (String) session.getAttribute("user_id");
	    
	    if (login_id != null) {
	    	mav.setViewName("redirect:/trainmain");
	    } else {
	    mav.setViewName("loginView");
	    }
	    return mav;
	  }
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	protected ModelAndView logout(PartyVO vo, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String login_id = (String) session.getAttribute("user_id");
		System.out.println("어디보자 : " + vo.toString());
		System.out.println("이름이 뭐니? : " + login_id);
		if (login_id!=null && session != null) {
			session.removeAttribute("user_id");
			session.invalidate();
			mav.addObject("msg", "안전하게 로그아웃 되었습니다.");
			mav.setViewName("loginView");
		}
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	protected ModelAndView loginControl(String action, MemberVO vo, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		System.out.println("login start");
		System.out.println("get POST");
		String viewName = null;
		if (vo.getUser_id() != null && vo.getPasswd() != null) {
			if (action != null && action.equals("login")) {
				System.out.println("액션 : " + action);
				System.out.println("조건 충족");
				System.out.println("vo 프린트 : " + vo.toString());
				boolean result = memberDAO.login(vo);
				if (result) {
					mav.addObject("msg", vo.getUser_id() + "님 반갑습니다.");
					session.setAttribute("user_id", vo.getUser_id());
					System.out.println();
					viewName = "welcome";
					System.out.println("맞다");
				} else {
					mav.addObject("msg", "로그인 실패");
					viewName = "loginView";
					System.out.println("틀렸따");
				}
			}
		}
		System.out.println("완료 finish POST");
		mav.setViewName(viewName);
		return mav;
	}
	
}