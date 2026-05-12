import java.util.Scanner;

public class Solution {
	
	static int gcd(int a, int b) {
		if(b==0) return a;
		return gcd(b, a%b);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			String command = sc.next();
			
			// 시작 a, b
			int a = 1;
			int b = 1;
			
			for(int i=0; i<command.length(); i++) {
				char go = command.charAt(i);
				
				if(go == 'L') b = a+b;
				else a = a+b;
			}
			
			int g = gcd(a, b);
			
			a = a / g;
			b /= g;
			
			System.out.println("#" + t +  " " + a + " " + b);
		}
	}
}