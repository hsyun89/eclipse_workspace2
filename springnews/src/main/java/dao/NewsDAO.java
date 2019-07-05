package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.NewsVO;
@Repository
public class NewsDAO {
	@Autowired
	SqlSession session = null;	
	public List<NewsVO> listAll(){
		List<NewsVO> list=null;
		String statement = "resource.NewsMapper.selectAllNews";
		list = session.selectList(statement);
		return list;
	}
	
	public NewsVO listOne(int id) {
		NewsVO result=null;
		String statement = "resource.NewsMapper.selectOneNews";
		result = session.selectOne(statement,id);
		result.setCnt(result.getCnt()+1);
		update(result);
		System.out.println(result);
		return result;
	}
	public NewsVO listOneCount(NewsVO vo) {
		NewsVO result=null;
		String statement = "resource.NewsMapper.selectOneNewsCount";
		result = session.selectOne(statement,vo);
		return result;
	}
	
	
	public boolean insert(NewsVO vo) {
		boolean result=true;
		String statement = "resource.NewsMapper.insertNews";
		if(session.insert(statement, vo) != 1)
			result = false;
		return result;
	}

	public boolean update(NewsVO vo) {
		boolean result=true;
		String statement = "resource.NewsMapper.updateNews";
		if(session.update(statement, vo) != 1)
			result = false;
		return result;	
	}

	public boolean delete(int id) {
		boolean result=true;
		String statement = "resource.NewsMapper.deleteNews";
		if(session.delete(statement, id) != 1)
			result = false;
		return result;
	}


}
