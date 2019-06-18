package jenkins.practice.jenkins;

import java.util.Scanner;

public class jenkinsCheck {

	public static void main(String[] args) {
		/*
		//fibonnacci series
		
		System.out.println("*****Fibonnacci series*****");
		int n1 = 0;
		int n2 = 1 ;
		
	
	System.out.print(n1 +" " + n2 +" ");
	
	for (int i = 1; i<=10; i++) {
		int n3 = n1 + n2;
		n1 = n2;
		n2 = n3;
		System.out.print(n3 +" ");
		
	}
	System.out.println();
	
	//palindrome
	System.out.println("******integer palindrome******");
	
	
	int number = 171;
	int sum = 0; int last ; int a;
	a = number;
	
	while (a>0) {
		last = a%10;
		
		sum = (sum*10)+last;
		
		a= a/10;
		
	}
	if (sum==number) {
		System.out.println("Number is Palindrome");
	}
	else {
		System.out.println("Number is not palindrom");
	}
	
	
	System.out.println("******String palindrome******");
	
	String a1, b ="";
	Scanner sc = new Scanner (System.in);
	a1 = sc.nextLine();
	
	int b2 = a1.length();
	
	for (int i= b2 - 1; i >=0; i -- ) {
		b = b + a1.charAt(i);
	}
	
	if (a1.equalsIgnoreCase(b)) {
		System.out.println("Its a palindrome string");
	}
	else
	{
		System.out.println("its not a palindrome");
	}
	
	
		//print program
		
		for (int i = 1; i<=5; i++) {
			for (int j = 1; j <=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	
	*/
		
	// reverse a string without reverse
	
		String st = "My name is Mathumathi";
		int i = st.length();
		StringBuffer stb = new StringBuffer();
		
		for (int j = i - 1; j>=0; j-- ) {
			stb = stb.append(st.charAt(j));
		}
		System.out.println(stb);
	
	}
}
