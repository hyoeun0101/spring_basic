package com.fastcampus.ch2;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

public class MethodInfo {
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("com.fastcampus.ch2.YoilTellerMVC");
		Object obj = clazz.newInstance();
		
		Method[] methodArr = clazz.getDeclaredMethods();//메소드 배열
		
		for(Method m : methodArr) {
			String name = m.getName();//메소드 이름
			Parameter[] paramArr = m.getParameters();//매개변수 배열
			Class[] paramTypeArr = m.getParameterTypes();//매개변수 타입 배열
			Class returnType = m.getReturnType();
			
			StringJoiner paramList = new StringJoiner("," , "(" , ")");
			
			for(Parameter p : paramArr) {
				String paramName = p.getName();
				Class paramType = p.getType();
				
				paramList.add(paramType.getName() + " " + paramName);
			}
			
			System.out.printf("%s %s%s\n", returnType.getName(), name, paramList);
		}
	}
}
