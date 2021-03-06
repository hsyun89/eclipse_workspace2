package model.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.vo.VisitorVO;

public class MeetingJDBCDAOtest {

	@Test
	public void test() {
		VisitorDAO dao = new VisitorDAO();
		VisitorVO vo = new VisitorVO();
		vo.setName("유니코");
		vo.setMemo("오늘은 불금!!");
		dao.insert(vo);
		ArrayList<VisitorVO> list = dao.listAll();
		for(VisitorVO data : list) 
			System.out.println(data);
		System.out.println("불금이 들어간 글**");
		list = dao.search("불금");
		for(VisitorVO data : list) 
			System.out.println(data);
	}

}
