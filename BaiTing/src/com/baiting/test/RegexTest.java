package com.baiting.test;


public class RegexTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String name = "S.H.E��she��,���ֺ�";
		String regex = "(.*)[\\(|��](.*)[\\)|��](.*)";
		name = name.replaceAll(regex, "$1$3");
	   System.out.println(name);

	}

}
