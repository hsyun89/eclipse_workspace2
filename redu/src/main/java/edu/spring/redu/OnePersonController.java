package edu.spring.redu;
import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import rjava.OnePersonService;
import rjava.RGraph2;
@Controller
public class OnePersonController {
	@Autowired
	RGraph2 rg2;	
	@Autowired
	OnePersonService rl;
	@RequestMapping("/map77")
	public ModelAndView get8(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		String real_path = req.getSession().getServletContext().getRealPath("/");
		System.out.println(real_path);
	    real_path = real_path.replace("\\", "/");
	    System.out.println(real_path);		
		File f = new File(real_path+"/resources/map7Var");
		if(!f.exists()) f.mkdir();
		String type = req.getParameter("type");
		if(type == null)
			type = "강남구";
		String result = rl.returnMap7(real_path+"/resources/map7Var", type);
		mav.addObject("map7Content", "http://localhost:8000/redu/resources/map7Var/"+result);
		mav.setViewName("oneView");
		return mav;
	}	

}
