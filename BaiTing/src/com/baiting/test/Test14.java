package com.baiting.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test14 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String line1 = "var data = [{\"t\":\"��\", \"s\":\"������\", \"i\":\"\", \"a\":\"���ɹ��ﳬ��Ʒ��ɫϵ��\", \"l\":1, \"r\":0,\"rt\":\"1\"},{\"t\":\"ˮ��\", \"s\":\"֣�ǻ�\", \"i\":\"\", \"a\":\"������ѡ\", \"l\":1, \"r\":0,\"rt\":\"0\"}";
		
		Pattern pattern = Pattern.compile("\\{\\s*(.*?)\\s*\\}");
		Matcher matcher = pattern.matcher(line1);
		while(matcher.find()) {
			System.out.println(matcher.group());
		}
	}

}
