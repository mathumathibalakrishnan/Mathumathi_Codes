package com.demo.code.com.java.code;

import java.util.ArrayList;
import java.util.Scanner;

public class testcode {

	public static void main(String[] args) {
	/*
		//Find out the number is odd or even
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		
		if (i%2 ==0) {
			System.out.println("Entered number is EVEN");
			
			
		}
		else {
			System.out.println("Entered number is ODD");
		}
		
		
		//Reverse Order of a String – totalqa
		
		String s1 = "totalqa";
		StringBuilder s2 = new StringBuilder();
		s2.append(s1);
		s2 = s2.reverse();
		System.out.println(s2);
		
		
		String s3 = "mathumathi";
		char[] s4 = s3.toCharArray();
		for (int i = s4.length-1; i>=0; i--) {
			System.out.print(s4[i]);
		}
		
		
		//Palindrome of the string
		String s = "malayalam";
		String reverse = new StringBuffer(s).reverse().toString();
		if (s.equals(reverse)) {
			System.out.println("Yes, its a palindrome string");
		}
		else {
			System.out.println("No, its not a palindrome string");
		}
		
		//Fibonacci series without recursion
		int n1=0, n2=1, n3, i, count = 10;
		System.out.print(n1+" "+n2);
		for (i=2; i<count; ++i) {
			n3 = n1+n2;
			System.out.print(" "+n3);
			n1=n2;
			n2=n3;
		}
		*/
		//Converting an String to Integer
		
		
		//Arraylist 
		ArrayList al = new ArrayList();
		al.add("mathu");
		al.add(123);
		al.add(null);
		System.out.println("Size of the list: "+al.size());
		
		for (int i=0; i<al.size(); i++) {
			System.out.println("Element at index " +i +" is "+al.get(i));
		}
		System.out.println("printing the list of each");
		for (Object o: al) {
			System.out.println("Element is "+o);
			
		}
		
	}

}
