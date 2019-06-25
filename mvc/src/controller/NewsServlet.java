package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NewsDAO;
import model.vo.NewsVO;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getParameter("action");
		String newsid= request.getParameter("newsid");
		NewsDAO dao=new NewsDAO();
		if(action==null && newsid==null) {//전체 리스트 출력
			request.setAttribute("list", dao.listAll());
		}else {
			if(action.equals("read")) { //타이틀 클릭 후 
				//System.out.println(0);
				request.setAttribute("listOne", dao.listOne(Integer.parseInt(newsid)));
			}else if(action.equals("delete")) { //삭제되고 리스트 출력
				dao.delete(Integer.parseInt(newsid));
				request.setAttribute("list", dao.listAll());
			}
		}
		request.getRequestDispatcher("/jspexam/news.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action= request.getParameter("action");
		
		String id=request.getParameter("newsid");
		String writer=request.getParameter("writer");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String writedate=request.getParameter("writedate");
		String cnt=request.getParameter("cnt");
		
		NewsDAO dao=new NewsDAO();
		NewsVO vo=new NewsVO();
		vo.setWriter(writer);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWritedate(writedate);
		
		if(action!=null) {
			if(action.equals("insert")) { //뉴스 작성
				dao.insert(vo);
			}else if(action.equals("update")) { //뉴스 수정
				vo.setId(Integer.parseInt(id));
				vo.setCnt(Integer.parseInt(cnt));
				dao.update(vo);
			}
		}
		request.setAttribute("list", dao.listAll());
		request.getRequestDispatcher("/jspexam/news.jsp").forward(request, response);

	}
}
