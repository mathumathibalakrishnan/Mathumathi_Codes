package jenkins.practice.jenkins;

import java.util.Scanner;

public class jenkinsCheck {

	public static void main(String[] args) {
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
	int b1 = sc.nextInt();
	
	
	
	}
	
	
	
	
}
