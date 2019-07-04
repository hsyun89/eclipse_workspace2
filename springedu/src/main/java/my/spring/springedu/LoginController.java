package my.spring.springedu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.LoginService;
import vo.ResultVO;

@Controller
public class LoginController {
	@Autowired LoginService ls;
	@RequestMapping("/login")
	@ResponseBody
	public ResultVO login(String id, String passwd) {
		boolean flag = ls.login(id, passwd);
		ResultVO rvo = new ResultVO();
		if (flag == true) {
			rvo.setResult("ok");
			return rvo;
//			return "{\"loginf\" :" + rvo.getResult() + "}";
		} else {
			rvo.setResult("fail");
			return rvo;
//			return "{\"loginf\" :" + rvo.getResult() + "}";
		}
	}
}
