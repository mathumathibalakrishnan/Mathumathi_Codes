package mobileweb;

import java.util.Scanner;

public class ifloop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//reverse();
//printPattern();
//evnOrodd();
replace();
replace12();
	}
	public static void evnOrodd() {
	Scanner in = new Scanner(System.in);
System.out.println("Enter any number: ");


int n = in.nextInt();
if (n%2 == 0) {
	System.out.println("Number entered is even");
	
}
else 
{
	System.out.println("Number entered is odd");
}

	}
public static void printPattern() {
		for (int i=1; i<=5; i++) {
			//System.out.println(i);
			for (int j= 1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
		public static void reverse() {
		String s = "mathumathi";
int i = s.length();
		StringBuffer sb = new StringBuffer();
		for (int j = i-1; j>=0; j--) {
			sb = sb.append(s.charAt(j));
			
		}
		System.out.println(sb);
	}
	
		
	public static void replace() {
		String str = "I use selenium interesting for";
		String toBeReplaced = "interesting";
		String toReplacedwith = "Boring";
		String[] astr = str.split(toBeReplaced);
		StringBuffer strb = new StringBuffer();
		for (int i=0; i<=astr.length -1; i++) {
			strb = strb.append(astr[i]);
			if (i!=astr.length - 1) {
				strb = strb.append(toReplacedwith);
			}
		}
		System.out.println(strb);
			}
		
	
	
		
		
public static void replace12() {
String str = " i used selenium for webdriver";
String toBeReplaced = "selenium";
String toReplacedWith = "Firefox";
String[] astr = str.split(toBeReplaced);
StringBuffer strb = new StringBuffer();
for ( int i = 0; i <= astr.length - 1; i++ ) {
strb = strb.append( astr[i] );
if (i != astr.length- 1) {
strb = strb.append(toReplacedWith);
}
}
System.out.println(strb);

}
}
