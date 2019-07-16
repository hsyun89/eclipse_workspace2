package trainproj.spring.springtrain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.TrainDAO;

@Controller
public class TrainController {
	@Autowired
	TrainDAO dao;
	@RequestMapping(value = "/trainmain", method = RequestMethod.GET)
	public ModelAndView showLogin() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",dao.listAll());
		mav.setViewName("workoutList");
		return mav;
	}	
}