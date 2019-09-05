package edu.spring.redu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import rjava.ROracleDB;
import rjava.RTestDAO;
@Controller
public class RDBController {
	@Autowired
	ROracleDB rdb;
	@Autowired
	RTestDAO rtb;
	@RequestMapping("/visitorAll")
	public ModelAndView get1() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", rdb.returnDBData(1));
		mav.setViewName("rdbview");
		return mav;
	}	
	@RequestMapping("/visitorAllOrderByName")
	public ModelAndView get2() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", rdb.returnDBData(2));
		mav.setViewName("rdbview");
		return mav;
	}	
	@RequestMapping("/visitorByName")
	public ModelAndView get3(String name) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", rdb.returnDBData("\\'"+name+"\\'"));
		mav.setViewName("rdbview");
		return mav;
	}	
	@RequestMapping("/insertVisitor")
	public ModelAndView proc(String name, String content) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", rdb.insertDBData("\\'"+name+"\\'", "\\'"+content+"\\'"));
		mav.setViewName("rdbview");
		return mav;
	}	
	@RequestMapping("/createTable")
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", rtb.createTable());
		mav.setViewName("rdbview");
		return mav;
	}	
	@RequestMapping("/dropTable")
	public ModelAndView drop() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", rtb.dropTable());
		mav.setViewName("rdbview");
		return mav;
	}	
	@RequestMapping("/listTable")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", rtb.listTable());
		mav.setViewName("rdbview");
		return mav;
	}	
}






