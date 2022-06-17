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
		//1.���� ����
		session.invalidate();
		return "redirect:/";
	}
	
	
	@PostMapping("/login")
	public String login(String id, String pwd, boolean rememberId, HttpServletResponse response,HttpServletRequest request) throws Exception {
		System.out.println("id="+id);
		System.out.println("pwd="+pwd);
		System.out.println("rememberId="+rememberId);
		// 1. id�� pwd�� Ȯ��
		if(!loginCheck(id, pwd)) {
			// 2-1   ��ġ���� ������, loginForm���� �̵�
			String msg = URLEncoder.encode("id �Ǵ� pwd�� ��ġ���� �ʽ��ϴ�.", "utf-8");
			
			return "redirect:/login/login?msg="+msg;
		}
		
		// 2-2. id�� pwd�� ��ġ�ϸ�,
		//���� ��ü�� ���̵� ����
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		// ���̵� ��� üũ�ϸ�
		if(rememberId) {
		//     1. ��Ű�� ����
			Cookie cookie = new Cookie("id", id);
			response.addCookie(cookie);
		} else {
// 		       1. ��Ű�� ����
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0); // ��Ű�� ����
//		       2. ���信 ����
			response.addCookie(cookie);
		}
//		3. Ȩ���� �̵�
		return "redirect:/";
	}

	private boolean loginCheck(String id, String pwd) {
		return "qqqq".equals(id) && "1234".equals(pwd);
	}
}