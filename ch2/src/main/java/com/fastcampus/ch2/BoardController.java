package com.fastcampus.ch2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	@GetMapping("/list")
	public String list(HttpServletRequest request) {

		//�α��� �������� loginForm ����
		if(!loginCheck(request)) {
			return "redirect:/login/login";
		}
		//�α��� �ߴٸ� boardList ��
		
		return "boardList";
		
	}

	private boolean loginCheck(HttpServletRequest request) {
		//������ �� ���ǿ� ���̵� �ִ��� üũ
		HttpSession sessoin = request.getSession();
//		if(sessoin.getAttribute("id") != null)
//			return true;
//		else
//			return false;
		return sessoin.getAttribute("id") != null;
	}
}
