package com.fastcampus.ch2;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

public class MethodInfo {
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("com.fastcampus.ch2.YoilTellerMVC");
		Object obj = clazz.newInstance();
		
		Method[] methodArr = clazz.getDeclaredMethods();//�޼ҵ� �迭
		
		for(Method m : methodArr) {
			String name = m.getName();//�޼ҵ� �̸�
			Parameter[] paramArr = m.getParameters();//�Ű����� �迭
			Class[] paramTypeArr = m.getParameterTypes();//�Ű����� Ÿ�� �迭
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
