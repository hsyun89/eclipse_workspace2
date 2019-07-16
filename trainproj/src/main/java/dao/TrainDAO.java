package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.TrainVO;

@Repository
public class TrainDAO {
	@Autowired
	SqlSession session = null;
	
	public List<TrainVO> listAll(){
		List<TrainVO> list=null;
		String statement = "resource.MemberMapper.selectAllTrain";
		list = session.selectList(statement);
		return list;
	}
}
