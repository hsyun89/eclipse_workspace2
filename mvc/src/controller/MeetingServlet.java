package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MeetingJDBCDAO;
import model.vo.MeetingVO;

@WebServlet("/meeting")
public class MeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		
		MeetingJDBCDAO dao = new MeetingJDBCDAO();
		if (keyword == null) {
			if (action=="delete") {
				boolean result = dao.delete(Integer.parseInt(id));
				if (result) {
					request.setAttribute("msg", "정보가 성공적으로 삭제되었어요!!");
				} else {
					request.setAttribute("msg", "정보 삭제를 실패했어요!!");
				}
			}
//			}else if(action=="update") {
//				boolean result = dao.selectOne(Integer.parseInt(id));
//				if (result) {
//					request.setAttribute("msg", "정보가 성공적으로 삭제되었어요!!");
//				} else {
//					request.setAttribute("msg", "정보 삭제를 실패했어요!!");
//				}
//			}
			request.setAttribute("list", dao.listAll());
		} else {
			List<MeetingVO> list = dao.search(keyword);
			if (list.size() == 0) {
				request.setAttribute("msg", keyword + "를 담고있는 정보가 없어요");
			} else {
				request.setAttribute("list", list);
			}
		}
		request.getRequestDispatcher("/jspexam/meetingView2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String meetingDate = request.getParameter("meetingDate");
		MeetingJDBCDAO dao = new MeetingJDBCDAO();
		MeetingVO vo = new MeetingVO();
		vo.setName(name);
		vo.setTitle(title);
		vo.setMeetingDate(meetingDate);
		boolean result = dao.insert(vo);
		if (result) {
			request.setAttribute("msg", name + "님의 정보가 성공적으로 입력되었어요!!");
		} else {
			request.setAttribute("msg", name + "님의 정보 입력 실패");
		}
		request.setAttribute("list", dao.listAll());
		request.getRequestDispatcher("/jspexam/meetingView2.jsp").forward(request, response);
	}
}
