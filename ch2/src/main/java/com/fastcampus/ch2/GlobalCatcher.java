package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice("com.fastcampus.ch2")
public class GlobalCatcher {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
	public String catcher() {
		System.out.println("==========Global Catcher=============");
		return "error";
	}
	
}
