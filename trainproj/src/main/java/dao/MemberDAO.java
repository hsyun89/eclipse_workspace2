package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.MemberVO;

@Repository
public class MemberDAO {
	@Autowired
	SqlSession session = null;

	public boolean register(MemberVO vo) throws Exception {
		boolean result = true;
		try {
			String statement = "resource.MemberMapper.register";
			int regVo = session.insert(statement, vo);
			if (regVo != 1) {
				result = false;
			}
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	public boolean login(MemberVO vo) {
		boolean result = true;
		String statement = "resource.MemberMapper.login";
		MemberVO logVo = session.selectOne(statement, vo);
		if (logVo == null) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}
}
