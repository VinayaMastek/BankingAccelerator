package com.mastek;

public class test {

	public static void main(String[] args) {
		String k = "other_account.holder:name";
		String x  = "name";
		
		System.out.println(k);
		
		String[] first = k.split("\\.");
		String[] second = x.split("\\.");
		
		System.out.println("first = "+first.length);
		System.out.println("second = "+ second.length);

	}

}
