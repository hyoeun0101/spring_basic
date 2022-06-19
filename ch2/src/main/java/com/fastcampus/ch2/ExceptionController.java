package com.fastcampus.ch2;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionController {
	

	@RequestMapping("/ex")	
	public void main(Model m) throws Exception{
		throw new Exception("예외가 발생");
	}
	
	
	@RequestMapping("/ex2")
	public void main2() throws Exception{
		throw new NullPointerException("예외 발생");
	}
}
