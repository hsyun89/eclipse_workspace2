package dao;

import java.sql.Array;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.ParticipantVO;
import vo.PartyVO;

@Repository
public class PartyDAO {
	@Autowired
	SqlSession session = null;

//////////////////////////1단계//////////////////////////
	public List<PartyVO> listAll() {
		// session = sqlSessionFactory.openSession();
		ParticipantVO parvo = new ParticipantVO();
		List<PartyVO> list = null;
//		vo.setParticipant_size(count(parvo.getParty_id()));
		String statement = "resource.PartyMapper.selectParty";
		list = session.selectList(statement);
		for (int i = 0; i < list.size(); i++) {
				list.get(i).setParticipant_size(count(list.get(i).getParty_id()));
		}
		return list;
	}
	
	

	public boolean insert(PartyVO vo) {
		boolean result = false;

		String statement = "resource.PartyMapper.insertParty";
		session.insert(statement, vo);
		result = true;
		
		if(result==true) {
			vo = listOne(vo.getPost_number());
			ParticipantVO parvo = new ParticipantVO();
			parvo.setParty_id(vo.getParty_id());
			parvo.setUser_id(vo.getUser_id());
			result = join(parvo);
		}
		return result;
	}

	public boolean delete(int post_number) {
		boolean result = true;

		String statement = "resource.PartyMapper.deleteParty";
		if (session.delete(statement, post_number) != 1) {
			result = false;
		}
		return result;
	}

	public boolean update(PartyVO vo) {
		boolean result = true;

		String statement = "resource.PartyMapper.updateParty";
		
		if (session.update(statement, vo) != 1) {
			result = false;
		}
		return result;
	}

	public PartyVO listOne(int post_number) {
		PartyVO result = null;
		String statement = "resource.PartyMapper.listOneParty";
		result = session.selectOne(statement, post_number);
		//update(result);
		
		return result;
	}
	
	
	//////////////////////////2단계//////////////////////////
	public boolean check(ParticipantVO parvo) {
		boolean result = false;
		String statement = "resource.PartyMapper.checkParty";
		ParticipantVO pid = session.selectOne(statement, parvo);
		if (pid != null) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	
	public boolean join(ParticipantVO parvo) {
		boolean result = true;
//		System.out.println("나는 뭐지 : " + parvo);
		String statement = "resource.PartyMapper.joinParty";
		boolean resultCheck = check(parvo);
//		System.out.println("체크 result : " + resultCheck);
		if (resultCheck) {
			result = false;
		} else {
			int pid = session.insert(statement, parvo); 
			if (pid != 1) {
			result = false;
			}
		}
		return result;
	}

	public boolean cancel(ParticipantVO parvo) {
		boolean result = true;
		String statement = "resource.PartyMapper.cancelJoin";
		int pid = session.delete(statement, parvo); 
		if (pid!=1) {
			result = false;
		}
		return result;
		}
	
	public int count(int party_id) {
		List<ParticipantVO> list = null;

		String statement = "resource.PartyMapper.countParty";
		list = session.selectList(statement, party_id);
		return list.size();
	}
	
	public List<ParticipantVO> listMember(int party_id) {
		List<ParticipantVO> parlist = null;
		String statement = "resource.PartyMapper.checkParticipant";
		parlist = session.selectList(statement,party_id);
		return parlist;
	}
	public List<PartyVO> searchTitle(String keyword) {
	       List<PartyVO> list = null;
	       String statement = "resource.PartyMapper.searchPartyTitle";
	       list = session.selectList(statement, keyword);
	        for (int i = 0; i < list.size(); i++) {
	            list.get(i).setParticipant_size(count(list.get(i).getParty_id()));
	    }
	       return list;
	   }
	    public List<PartyVO> searchLocation(String keyword) {
	        List<PartyVO> list = null;
	        String statement = "resource.PartyMapper.searchPartyLocation";
	        list = session.selectList(statement, keyword);
	        for (int i = 0; i < list.size(); i++) {
	            list.get(i).setParticipant_size(count(list.get(i).getParty_id()));
	    }
	        return list;
	    }
	    public List<PartyVO> searchUser_id(String keyword) {
	        List<PartyVO> list = null;
	        String statement = "resource.PartyMapper.searchPartyUser_id";
	        list = session.selectList(statement, keyword);
	        for (int i = 0; i < list.size(); i++) {
	            list.get(i).setParticipant_size(count(list.get(i).getParty_id()));
	        }
	        return list;
	    }
	    public List<PartyVO> searchContents(String keyword) {
	        List<PartyVO> list = null;
	        String statement = "resource.PartyMapper.searchPartyContents";
	        list = session.selectList(statement, keyword);
	        for (int i = 0; i < list.size(); i++) {
	            list.get(i).setParticipant_size(count(list.get(i).getParty_id()));
	        }
	        return list;
	    }
	
}
