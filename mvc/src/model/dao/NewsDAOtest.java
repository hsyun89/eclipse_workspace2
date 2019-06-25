package model.dao;

import java.util.List;

import org.junit.Test;

import model.vo.NewsVO;

public class NewsDAOtest {

	@Test
	public void test() {
		NewsDAO dao = new NewsDAO();
		NewsVO vo = new NewsVO();
		vo.setWriter("도우너");
		vo.setTitle("깐따삐야!");
		vo.setContent("우주선 사고로 생존");
		vo.setId(5);
//		dao.insert(vo);
		dao.update(vo);
		
		
//		System.out.println(dao.listOne(4));
		
//		dao.delete(4);
		List<NewsVO> list = dao.listAll();
		for(NewsVO data : list) 
			System.out.println(data);
	}

}
