package edu.spring.springnews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.NewsDAO;
import vo.NewsVO;

@Controller
public class NewsController {
	@Autowired
	NewsDAO dao;
	@RequestMapping(value = "/newsmain", method = RequestMethod.GET)
	protected ModelAndView get(String newsid,String action) {
		ModelAndView mav = new ModelAndView();
		
		if (action == null && newsid == null) {// 전체 리스트 출력
			mav.addObject("list",dao.listAll());
		} else {
			if (action.equals("read")) { // 타이틀 클릭 후
				mav.addObject("listOne", dao.listOne(Integer.parseInt(newsid)));
			} else if (action.equals("delete")) { // 삭제되고 리스트 출력
				dao.delete(Integer.parseInt(newsid));
				mav.addObject("list", dao.listAll());
			}
		}
		mav.setViewName("news");
		return mav;
	}
	@RequestMapping(value = "/newsmain", method = RequestMethod.POST)
	protected ModelAndView post(String newsid,String action, String writer,String title,String content,String writedate,String cnt) {
		ModelAndView mav = new ModelAndView();
		NewsVO vo = new NewsVO();
		vo.setWriter(writer);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWritedate(writedate);

		if (action != null) {
			if (action.equals("insert")) { // 뉴스 작성
				dao.insert(vo);
			} else if (action.equals("update")) { // 뉴스 수정
				vo.setId(Integer.parseInt(newsid));
				vo.setCnt(0);
				dao.update(vo);
			}
		}
		mav.addObject("list", dao.listAll());
		mav.setViewName("news");
		return mav;

	}
}
