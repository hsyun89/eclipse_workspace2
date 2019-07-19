package trainproj.spring.springtrain;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import dao.PartyDAO;
import vo.ParticipantVO;
import vo.PartyVO;

@Controller
public class PartyController {
	@Autowired
	PartyDAO dao;

	@RequestMapping(value = "/partymain", method = RequestMethod.GET)
	protected ModelAndView get(String action, String select, String post_number, HttpSession session) {
		ModelAndView mav = new ModelAndView();
//		ModelAndView mav_default = new ModelAndView();
		List<PartyVO> list = null;
		list = dao.listAll();
		System.out.println(list);
		String user = (String) session.getAttribute("user_id");
		String viewName = "PartyView";

		// list
		if (action == null) {
			if (list != null && list.size() != 0) {
				mav.addObject("list", list);
			}
		}

		if (post_number != null) {
			int i_post_number = Integer.parseInt(post_number);
			PartyVO vo = null;
			// read
			if (action.equals("read")&&select == null) {
//				PartyVO vo = dao.listOne(i_post_number);
				vo = dao.listOne(i_post_number);
				vo.setParticipant_size(dao.count(vo.getParty_id()));
				
				if (vo != null) {
				mav.addObject("vo", vo);
				}

				// member
				if (vo.getParty_id() != 0) {
					List<ParticipantVO> parlist = null;
					parlist = dao.listMember(vo.getParty_id());
					System.out.println("하나 클릭 체크 : " + parlist);
					mav.addObject("parlist", parlist);
				}
				if (!user.equals(vo.getUser_id())) {
					viewName = "PartyDetail"; // 참가 신청 뷰
				}
			}
			// delete
			else if (action.equals("delete")&&user!=null) {
				boolean result = dao.delete(i_post_number);
				if (result) {
					mav.addObject("msg", "글 삭제 성공");
					System.out.println("삭제");
				} else {
					mav.addObject("msg", "글 삭제 실패");
				}
				mav.addObject("list", dao.listAll());
			}
			// join
			else if (select.equals("join")&&user!=null) {
//				PartyVO vo = dao.listOne(i_post_number);
				vo = dao.listOne(i_post_number);
				ParticipantVO parvo = new ParticipantVO();
				System.out.println("before : " + parvo.toString());
				parvo.setParty_id(vo.getParty_id());
				parvo.setUser_id(user);
				System.out.println("After : " + parvo.toString());
				boolean result = dao.join(parvo);
				System.out.println("조인 vo 아이디 : " + vo.getUser_id());
				System.out.println("조인 action:" + action);
				System.out.println("조인 number:" + post_number);
				System.out.println("조인 id:" + user);
				System.out.println("참가신청 result 값 : " + result);
				if (result) {
					mav.addObject("msg", "신청 완료");
				}
				else {
					mav.addObject("msg", "이미 신청한 이벤트입니다.");
				}
				vo.setUser_id(user);
				mav.addObject("vo", dao.listOne(i_post_number));
				if (vo.getParty_id() != 0) {
					List<ParticipantVO> parlist = null;
					parlist = dao.listMember(vo.getParty_id());
					System.out.println("하나 클릭 체크 : " + parlist);
					mav.addObject("parlist", parlist);
				}
				viewName = "PartyDetail";
			} else if (select.equals("cancel")&&user!=null) {
//				PartyVO vo = dao.listOne(i_post_number);
				vo = dao.listOne(i_post_number);
				ParticipantVO parvo = new ParticipantVO();
				parvo.setParty_id(vo.getParty_id());
				parvo.setUser_id(user);
				System.out.println("취소 vo 아이디 : " + vo.getUser_id());
				System.out.println("취소 action:" + action);
				System.out.println("취소 id:" + user);
				boolean result = dao.cancel(parvo);
				if (!result) {
					mav.addObject("msg", "참가된 이벤트가 아닙니다.");
				} else {
					mav.addObject("msg", "참가 취소 완료");
				}
				vo.setUser_id(user);
				System.out.println("취소 vo 아이디 수정 후 : " + vo.getUser_id());
				System.out.println("취소 vo 투 스트링 : " + vo.toString());
				mav.addObject("vo", dao.listOne(i_post_number));
				if (vo.getParty_id() != 0) {
					List<ParticipantVO> parlist = null;
					parlist = dao.listMember(vo.getParty_id());
					System.out.println("하나 클릭 체크 : " + parlist);
					mav.addObject("parlist", parlist);
				}
				viewName = "PartyDetail";
			}

		}
		mav.setViewName(viewName);
		return mav;
	}

	@RequestMapping(value = "/partymain", method = RequestMethod.POST)
	protected ModelAndView post(String party_id, String title, String party_size, String contents, String location,
			String post_number, String action, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String viewName = "PartyView";
		String user = (String) session.getAttribute("user_id");

		//
		System.out.println("post action:" + action);
		System.out.println("post number:" + post_number);
		System.out.println("post party:" + party_id);

		if (!action.equals(null)) {

			PartyVO vo = new PartyVO();
			vo.setTitle(title);
			vo.setContents(contents);
			vo.setParty_size(Integer.parseInt(party_size));
			vo.setLocation(location);
			vo.setUser_id(user);

			// insert
			if (action.equals("insert")) {
				boolean result = dao.insert(vo);
				if (result) {
					mav.addObject("msg", vo.getUser_id() + "님의 글 작성 성공");
				} else {
					mav.addObject("msg", vo.getUser_id() + "님의 글 작성 실패");
				}

			}

			// update
			else if (action.equals("update")) {

				int i_post_number = Integer.parseInt(post_number);
				vo.setPost_number(i_post_number);

				boolean result = dao.update(vo);
				if (result) {
					mav.addObject("msg", "글 수정 성공");
				} else {
					mav.addObject("msg", "글 수정 실패");
				}
			}
			mav.addObject("list", dao.listAll());
		}

		mav.setViewName(viewName);
		return mav;
	}

}
