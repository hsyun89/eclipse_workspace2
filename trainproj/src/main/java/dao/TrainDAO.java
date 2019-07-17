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
		String statement = "resource.TrainMapper.selectAllTrain";
		list = session.selectList(statement);
		return list;
	}
	public boolean plusMaster(TrainVO vo) {
		boolean result=true;
		String statement = "resource.TrainMapper.plusTrainMaster";
		if(session.insert(statement, vo) != 1)
			result = false;
		return result;
	}
	public boolean plus(TrainVO vo) {
		boolean result=true;
		String statement = "resource.TrainMapper.plusTrain";
		if(session.insert(statement, vo) != 1)
			result = false;
		return result;
	}
	public boolean delete(int code) {
		boolean result=true;
		String statement = "resource.TrainMapper.deleteTrain";
		if(session.insert(statement, code) != 1)
			result = false;
		return result;
	}
	public boolean edit(TrainVO vo) {
		boolean result=true;
		String statement = "resource.TrainMapper.editTrain";
		if(session.insert(statement, vo) != 1)
			result = false;
		return result;
	}
	public boolean update1(TrainVO vo) {
		boolean result=true;
		String statement = "resource.TrainMapper.update1";
		if(session.insert(statement, vo) != 1)
			result = false;
		return result;
	}
	
}
