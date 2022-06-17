package com.fastcampus.ch2;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
// Controller ���

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
		//1. ���� ������ �� �پ� �о �ϳ��� ���ڿ��� �����
		Scanner sc = new Scanner(new File(viewName+".txt"));
		
		while(sc.hasNextLine()) {
			result += sc.nextLine() + System.lineSeparator();
		}

		//map�� ��� key�� �ޱ�
		Iterator iter = map.keySet().iterator();
		//${key}  -> Ű�� ������ replace
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