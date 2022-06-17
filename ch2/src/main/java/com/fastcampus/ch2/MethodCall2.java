package com.fastcampus.ch2;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
//Reflection API 이용해서 MVC 패턴 구현하기

public class MethodCall2 {
	public static void main(String[] args) throws Exception{
		Class clazz = Class.forName("com.fastcampus.ch2.YoilTellerMVC");
		Object obj = clazz.newInstance();

		Method main = clazz.getDeclaredMethod("main", int.class, int.class, int.class, Model.class);

		Model model = new BindingAwareModelMap();
		System.out.println("[before] model=  "+model);

		//Reflection API이용하여 main 메소드에 Object배열로 매개변수 넣어주기
		//String viewName = obj.main(2021,10,1,model);  //와 같음
		String viewName =(String) main.invoke(obj, new Object[] {2021, 10,1,model});
		System.out.println("viewName = "+viewName);

		//Model 내용 출력
		System.out.println("[after] model="+model);

		render(model, viewName);

	}

	static void render(Model model, String viewName) throws IOException{
		String result = "";
		// 1. 뷰의 내용을 한줄씩 읽어서 하나의 문자열로 만든다.
		Scanner sc = new Scanner(new File("src/main/webapp/WEB-INF/views/"+viewName+".jsp"), "utf-8");

		while(sc.hasNextLine())
			result += sc.nextLine()+ System.lineSeparator();

		// 2. model을 map으로 변환 
		Map map = model.asMap();

		// 3.key를 하나씩 읽어서 template의 ${key}를 value바꾼다.
		Iterator it = map.keySet().iterator();

		while(it.hasNext()) {
			String key = (String)it.next();

			// 4. replace()로 key를 value 치환한다.
			result = result.replace("${"+key+"}", ""+map.get(key));
		}

		// 5.렌더링 결과를 출력한다.
		System.out.println(result);
	}

}


