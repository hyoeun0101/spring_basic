package com.fastcampus.ch2;



import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // ctrl+shift+o 자동 임포트 
public class RegisterController {
	@RequestMapping(value="/register/add", method= {RequestMethod.GET, RequestMethod.POST}) // 신규회원 가입
	public String register() {
		return "registerForm";  // WEB-INF/views/registerForm.jsp
	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST) // 신규회원 가입
 	@PostMapping("/register/save")
	public String save( User user, Model m) throws Exception {
		if(!isValid(user)) {
			String msg = URLEncoder.encode("유효하지않음.","utf-8");
			
			m.addAttribute("msg", msg);
			return "forward:/register/add"; // 신규회원 가입화면으로 이동(redirect)
		}
		
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return false;
	}
	
}