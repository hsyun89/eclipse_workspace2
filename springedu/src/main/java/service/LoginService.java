package service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public boolean login(String id, String passwd) {
		if(id.equals("spring")&&passwd.equals("@1234")) {
			return true;
		}else {
			return false;
		}
	}
}
