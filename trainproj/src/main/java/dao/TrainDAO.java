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

	public List<TrainVO> listAll(String user_id) {
		List<TrainVO> list = null;
		String statement = "resource.TrainMapper.selectAllTrain";
		list = session.selectList(statement, user_id);
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
		if (param1 == 0) {
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
		if (param1 == 0) {
			statement = "resource.TrainMapper.deleteFormula1";
			list = session.selectList(statement, vo);
		} else {
			statement = "resource.TrainMapper.deleteFormula2";
			vo.setGroupOrdTail(param1);
			list = session.selectList(statement, vo);
		}
		// 요기까지 하다감!
		list.add(vo.getCode());
//		statement = "resource.TrainMapper.deleteTrain";
//		if (session.delete(statement, vo.getCode()) != 1)
//			result = false;
		statement = "resource.TrainMapper.deleteTrain";
		for (int data : list) {
			session.delete(statement, data);
		}
		return result;
	}

	public boolean edit(TrainVO vo) {
		boolean result = true;
		String statement = "resource.TrainMapper.editTrain";
		if (session.update(statement, vo) != 1)
			result = false;
		return result;
	}

	public boolean collapseToExpand(int code) {
		boolean result = true;
		String statement = "resource.TrainMapper.collapseToExpandTrain";
		if (session.update(statement, code) != 1)
			result = false;
		return result;
	}

	public boolean expandToCollapse(int code) {
		boolean result = true;
		String statement = "resource.TrainMapper.expandToCollapseTrain";
		if (session.update(statement, code) != 1)
			result = false;
		return result;
	}

	public boolean collapseFlag(TrainVO vo) {
		boolean result = true;
		List<Integer> list = null;
		String statement = "resource.TrainMapper.formula1";
		int param1 = session.selectOne(statement, vo);
		if (param1 == 0) {
			statement = "resource.TrainMapper.deleteFormula1";
			list = session.selectList(statement, vo);
		} else {
			statement = "resource.TrainMapper.deleteFormula2";
			vo.setGroupOrdTail(param1);
			list = session.selectList(statement, vo);
		}
		statement = "resource.TrainMapper.updateCollpaseFlagTrain";
		for (int data : list) {
			session.update(statement, data);
		}
		return result;
	}

	public boolean expandFlag(TrainVO vo) {
		boolean result = true;
		List<Integer> list = null;
		String statement = "resource.TrainMapper.formula1";
		int param1 = session.selectOne(statement, vo);
		if (param1 == 0) {
			statement = "resource.TrainMapper.deleteFormula1_1";
			list = session.selectList(statement, vo);
		} else {
			statement = "resource.TrainMapper.deleteFormula2_1";
			vo.setGroupOrdTail(param1);
			list = session.selectList(statement, vo);
		}
		statement = "resource.TrainMapper.updateExpandFlagTrain";
		for (int data : list) {
			session.update(statement, data);
		}
		return result;
	}
	public boolean expandAll() {
		boolean result = true;
		String statement = "resource.TrainMapper.expandAll";
		if (session.insert(statement) != 1)
			result = false;
		return result;
	}
	public boolean collapseAll() {
		boolean result = true;
		String statement = "resource.TrainMapper.collapseAll";
		if (session.insert(statement) != 1)
			result = false;
		statement="resource.TrainMapper.collapseAllSecond";
		if (session.insert(statement) != 1)
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
