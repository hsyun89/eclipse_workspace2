package model.dao;

import java.util.ArrayList;

import org.junit.Test;

import vo.VisitorVO;

public class VisitorDAOTest {

	@Test
	public void test() {
		VisitorDAO dao = new VisitorDAO();
		ArrayList<VisitorVO> list = dao.listAll();
		for(VisitorVO vo : list) {
			System.out.println(vo);
		}
			
	}

}
