package trainproj.spring.springtrain;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.TrainDAO;
import vo.TrainVO;

@Controller
public class TrainController {
	@Autowired
	TrainDAO dao;

	@RequestMapping(value = "/trainmain", method = RequestMethod.GET)
	public ModelAndView get(String action, String code, String originNo, String groupOrd, String groupLayer,
			HttpSession session, String title) {
		ModelAndView mav = new ModelAndView();
		TrainVO vo = new TrainVO();
		String user_id = (String) session.getAttribute("user_id");
		if(user_id==null) {
			String viewName="loginView";
			mav.setViewName(viewName);
			return mav;
		}
		if (action != null) {
			if (action.equals("plusMaster")) {
					vo.setGroupOrd(0);
					vo.setGroupLayer(0);
					vo.setUser_id(user_id);
					dao.plusMaster(vo);
				}
			if (action.equals("plus2")) {
				vo.setOriginNo(Integer.parseInt(originNo));
				vo.setGroupOrd(Integer.parseInt(groupOrd));
				vo.setGroupLayer(Integer.parseInt(groupLayer));
				vo.setUser_id(user_id);
				dao.plus2(vo);
			}
//			if (action.equals("plus")) {
//				vo.setOriginNo(Integer.parseInt(originNo));
//				vo.setGroupOrd(Integer.parseInt(groupOrd));
//				vo.setGroupLayer(Integer.parseInt(groupLayer));
//				vo.setUser_id(user_id);
//				dao.update1(vo);
//				vo.setGroupOrd(Integer.parseInt(groupOrd)+1);
//				vo.setGroupLayer(Integer.parseInt(groupLayer) + 1);
//				dao.plus(vo);
//			}
			if (action.equals("delete")) {
				vo.setCode(Integer.parseInt(code));
				vo.setOriginNo(Integer.parseInt(originNo));
				vo.setGroupOrd(Integer.parseInt(groupOrd));
				vo.setGroupLayer(Integer.parseInt(groupLayer));
				dao.delete(vo);
			}
			if (action.equals("edit")) {
				vo.setCode(Integer.parseInt(code));
				vo.setTitle(title);
				dao.edit(vo);
			}
			if(action.equals("collapse")) {
				dao.collapseToExpand(Integer.parseInt(code));
				vo.setCode(Integer.parseInt(code));
				vo.setOriginNo(Integer.parseInt(originNo));
				vo.setGroupOrd(Integer.parseInt(groupOrd));
				vo.setGroupLayer(Integer.parseInt(groupLayer));
				dao.collapseFlag(vo);
			}
			if(action.equals("expand")) {
				dao.expandToCollapse(Integer.parseInt(code));
				vo.setCode(Integer.parseInt(code));
				vo.setOriginNo(Integer.parseInt(originNo));
				vo.setGroupOrd(Integer.parseInt(groupOrd));
				vo.setGroupLayer(Integer.parseInt(groupLayer));
				dao.expandFlag(vo);
			}
			if(action.equals("expandAll")) {
				dao.expandAll();
			}
			if(action.equals("collapseAll")) {
				dao.collapseAll();
			}
		}
		
		mav.addObject("list", dao.listAll(user_id));
		mav.setViewName("workoutList");
		return mav;
	}
}