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

	public List<TrainVO> listAll() {
		List<TrainVO> list = null;
		String statement = "resource.TrainMapper.selectAllTrain";
		list = session.selectList(statement);
		return list;
	}

	public boolean plusMaster(TrainVO vo) {
		boolean result = true;
		String statement = "resource.TrainMapper.plusTrainMaster";
		if (session.insert(statement, vo) != 1)
			result = false;
		return result;
	}

	public boolean plus(TrainVO vo) {
		boolean result = true;
		String statement = "resource.TrainMapper.plusTrain";
		if (session.insert(statement, vo) != 1)
			result = false;
		return result;
	}

	public boolean plus2(TrainVO vo) {
		boolean result = true;
		String statement = "resource.TrainMapper.formula1";
		int param1 = session.selectOne(statement, vo);
		if (param1==0) {
			statement = "resource.TrainMapper.formula2";
			int param2 = session.selectOne(statement, vo);
			vo.setGroupOrd(param2);
			vo.setGroupLayer(vo.getGroupLayer() + 1);
			statement = "resource.TrainMapper.plusTrain2";
			if (session.insert(statement, vo) != 1)
				result = false;
		} else {
			statement = "resource.TrainMapper.formula3";
			vo.setGroupOrd(param1);
			session.insert(statement, vo);
			vo.setGroupLayer(vo.getGroupLayer() + 1);
			statement = "resource.TrainMapper.plusTrain2";
			if (session.insert(statement, vo) != 1)
				result = false;
		}
		return result;
	}

//	public boolean delete(int code) {
//		boolean result = true;
//		String statement = "resource.TrainMapper.deleteTrain";
//		if (session.insert(statement, code) != 1)
//			result = false;
//		return result;
//	}
	
	public boolean delete(TrainVO vo) {
		boolean result = true;
		List<Integer> list = null;
		String statement = "resource.TrainMapper.formula1";
		int param1 = session.selectOne(statement, vo);
		if(param1==0) {
			statement = "resource.TrainMapper.deleteFormula1";
			list = session.selectList(statement,vo);
			System.out.println("하잇");
		}else {
			statement = "resource.TrainMapper.deleteFormula2";
			vo.setGroupOrdTail(param1);
			list = session.selectList(statement,vo);
			System.out.println("요");
		}
		System.out.println(list.toString());
//		statement = "resource.TrainMapper.deleteTrain";
//		if (session.delete(statement, vo.getCode()) != 1)
//			result = false;
		return result;
	}

	public boolean edit(TrainVO vo) {
		boolean result = true;
		String statement = "resource.TrainMapper.editTrain";
		if (session.update(statement, vo) != 1)
			result = false;
		return result;
	}

//	public boolean update1(TrainVO vo) {
//		boolean result = true;
//		String statement = "resource.TrainMapper.update1";
//		if (session.insert(statement, vo) != 1)
//			result = false;
//		return result;
//	}

}
