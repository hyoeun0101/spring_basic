package com.fastcampus.ch2;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//1.세션 종료
		session.invalidate();
		return "redirect:/";
	}
	
	
	@PostMapping("/login")
	public String login(String id, String pwd, boolean rememberId, String toURL,HttpServletResponse response,HttpServletRequest request) throws Exception {
		System.out.println("id="+id);
		System.out.println("pwd="+pwd);
		System.out.println("rememberId="+rememberId);
		// 1. id와 pwd를 확인
		if(!loginCheck(id, pwd)) {
			// 2-1   일치하지 않으면, loginForm으로 이동
			String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");
			
			return "redirect:/login/login?msg="+msg;
		}
		
		// 2-2. id와 pwd가 일치하면,
		//세션 객체에 아이디 저장
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		// 아이디 기억 체크하면
		if(rememberId) {
		//     1. 쿠키를 생성
			Cookie cookie = new Cookie("id", id);
			response.addCookie(cookie);
		} else {
// 		       1. 쿠키를 삭제
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0); // 쿠키를 삭제
//		       2. 응답에 저장
			response.addCookie(cookie);
		}
//		3. 홈으로 이동
	
		return "redirect:"+ ((toURL == null || toURL.equals("")) ? "/" : toURL);
	}

	private boolean loginCheck(String id, String pwd) {
		return "qqqq".equals(id) && "1234".equals(pwd);
	}
}