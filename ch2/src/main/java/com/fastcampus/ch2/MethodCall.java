package com.fastcampus.ch2;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
// Controller 사용

public class MethodCall {
	public static void main(String[] args) throws Exception {
		HashMap map  = new HashMap();
		System.out.println("befor : "+map);
		
		ModelController mc = new ModelController();
		String viewName = mc.main(map);
		
		System.out.println("after : "+map);
		
		render(map,viewName);
	}
	
	
	static void render(HashMap map, String viewName) throws IOException{
		String result = "";
		//1. 뷰의 내용을 한 줄씩 읽어서 하나의 문자열로 만들기
		Scanner sc = new Scanner(new File(viewName+".txt"));
		
		while(sc.hasNextLine()) {
			result += sc.nextLine() + System.lineSeparator();
		}

		//map에 담긴 key값 받기
		Iterator iter = map.keySet().iterator();
		//${key}  -> 키의 값으로 replace
		while(iter.hasNext()) {
			String key = (String) iter.next();
			result = result.replace("${" + key + "}", (String)map.get(key));
		}
		System.out.println(result);
	}
	
	
}


class ModelController{
	public String main(HashMap<String, String> map) {
		map.put("id", "qwer");
		map.put("pwd", "1111");
		
		return "txtView2";
	}
}