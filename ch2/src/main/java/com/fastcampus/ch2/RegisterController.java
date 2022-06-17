package com.fastcampus.ch2;



import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // ctrl+shift+o �ڵ� ����Ʈ 
public class RegisterController {
	@RequestMapping(value="/register/add", method= {RequestMethod.GET, RequestMethod.POST}) // �ű�ȸ�� ����
	public String register() {
		return "registerForm";  // WEB-INF/views/registerForm.jsp
	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST) // �ű�ȸ�� ����
 	@PostMapping("/register/save")
	public String save( User user, Model m) throws Exception {
		if(!isValid(user)) {
			String msg = URLEncoder.encode("��ȿ��������.","utf-8");
			
			m.addAttribute("msg", msg);
			return "forward:/register/add"; // �ű�ȸ�� ����ȭ������ �̵�(redirect)
		}
		
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return false;
	}
	
}