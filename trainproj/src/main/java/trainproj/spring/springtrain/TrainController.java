package trainproj.spring.springtrain;

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
			String user_id, String title) {
		TrainVO vo = new TrainVO();
		if (action != null) {
			if (action.equals("plusMaster")) {
					vo.setGroupOrd(0);
					vo.setGroupLayer(0);
					vo.setUser_id(user_id);
					dao.plusMaster(vo);
				}
			if (action.equals("plus")) {
				vo.setOriginNo(Integer.parseInt(originNo));
				vo.setGroupOrd(Integer.parseInt(groupOrd));
				vo.setGroupLayer(Integer.parseInt(groupLayer));
				vo.setUser_id(user_id);
				dao.update1(vo);
				vo.setGroupOrd(Integer.parseInt(groupOrd)+1);
				vo.setGroupLayer(Integer.parseInt(groupLayer) + 1);
				dao.plus(vo);
			}
			if (action.equals("delete")) {
				dao.delete(Integer.parseInt(code));
			}
			if (action.equals("edit")) {
				vo.setCode(Integer.parseInt(code));
				vo.setTitle(title);
				dao.edit(vo);
			}
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listAll());
		mav.setViewName("workoutList");
		return mav;
	}
}