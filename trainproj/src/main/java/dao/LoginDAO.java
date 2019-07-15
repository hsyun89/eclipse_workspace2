package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.LoginVO;

@Repository
public class LoginDAO {
	@Autowired
	SqlSession session = null;
	
	public LoginVO login(String user_id) {
		LoginVO result=null;
		String statement = "resource.NewsMapper.login";
		result=session.selectOne(statement, user_id);
		return result;
	}
}
