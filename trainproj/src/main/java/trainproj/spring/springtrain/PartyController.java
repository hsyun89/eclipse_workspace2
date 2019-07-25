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
	protected ModelAndView get(String action, String select, String post_number, String col, String keyword, HttpSession session) {		
		ModelAndView mav = new ModelAndView();
//		ModelAndView mav_default = new ModelAndView();
		List<PartyVO> list = null;
		list = dao.listAll();
		String user = (String) session.getAttribute("user_id");
		String viewName = "PartyView";
		if(user==null) {
			viewName="loginView";
			mav.setViewName(viewName);
			return mav;
		}
		// list
		if (action == null) {
			if (list != null && list.size() != 0) {
				mav.addObject("list", list);
			}
		}
		//search
		if (action!=null && action.equals("search")) {
           if (list.size() != 0 && col.equals("title")) {
               list = dao.searchTitle(keyword);
               mav.addObject("list", list);
           } else if (list.size() != 0 && col.equals("location")) {
               list = dao.searchLocation(keyword);
               mav.addObject("list", list);
           } else if (list.size() != 0 && col.equals("user_id")) {
               list = dao.searchUser_id(keyword);
               mav.addObject("list", list);
           } else if (list.size() != 0 && col.equals("contents")) {
               list = dao.searchContents(keyword);
               mav.addObject("list", list);
           } else {
               mav.addObject("msg", keyword + "로 검색된 정보가 없습니다.");
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
				} else {
					mav.addObject("msg", "글 삭제 실패");
				}
				mav.addObject("list", dao.listAll());
			}
			// join
			else if (select.equals("join") && user != null) {
//				PartyVO vo = dao.listOne(i_post_number);
				vo = dao.listOne(i_post_number);
				vo.setParticipant_size(dao.count(vo.getParty_id()));
				ParticipantVO parvo = new ParticipantVO();
				parvo.setParty_id(vo.getParty_id());
				parvo.setUser_id(user);
				if (vo.getParticipant_size() < vo.getParty_size()) {
					boolean result = dao.join(parvo);
					if (result) {
						mav.addObject("msg", "신청 완료");

					} else {
						mav.addObject("msg", "이미 신청한 이벤트입니다.");
					}
				} else {
					mav.addObject("msg", "인원이 초과 되었습니다.");
				}
				vo.setUser_id(user);
				mav.addObject("vo", dao.listOne(i_post_number));
				if (vo.getParty_id() != 0) {
					List<ParticipantVO> parlist = null;
					parlist = dao.listMember(vo.getParty_id());
					mav.addObject("parlist", parlist);
				}
				viewName = "PartyDetail";
				//cancel위까지
				
			} else if (select.equals("cancel")&&user!=null) {
//				PartyVO vo = dao.listOne(i_post_number);
				vo = dao.listOne(i_post_number);
				ParticipantVO parvo = new ParticipantVO();
				parvo.setParty_id(vo.getParty_id());
				parvo.setUser_id(user);
				boolean result = dao.cancel(parvo);
				if (!result) {
					mav.addObject("msg", "참가된 이벤트가 아닙니다.");
				} else {
					mav.addObject("msg", "참가 취소 완료");
				}
				vo.setUser_id(user);
				mav.addObject("vo", dao.listOne(i_post_number));
				if (vo.getParty_id() != 0) {
					List<ParticipantVO> parlist = null;
					parlist = dao.listMember(vo.getParty_id());
					mav.addObject("parlist", parlist);
				}
				viewName = "PartyDetail";
			}

		}

		mav.setViewName(viewName);
		return mav;
	}
//	}
	@RequestMapping(value = "/partymain", method = RequestMethod.POST)
	protected ModelAndView post(String party_id, String title, String party_size, String contents, String location,
			String post_number, String action, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String viewName = "PartyView";
		String user = (String) session.getAttribute("user_id");

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
