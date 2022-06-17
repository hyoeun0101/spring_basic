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

		//로그인 안했으면 loginForm 으로
		if(!loginCheck(request)) {
			return "redirect:/login/login";
		}
		//로그인 했다면 boardList 로
		
		return "boardList";
		
	}

	private boolean loginCheck(HttpServletRequest request) {
		//세션을 얻어서 세션에 아이디가 있는지 체크
		HttpSession sessoin = request.getSession();
//		if(sessoin.getAttribute("id") != null)
//			return true;
//		else
//			return false;
		return sessoin.getAttribute("id") != null;
	}
}
