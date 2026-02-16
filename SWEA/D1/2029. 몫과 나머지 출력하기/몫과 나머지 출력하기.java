import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.println("#" + t + " " + a/b + " " + a%b); 
			// a / b : 몫 (정수 나눗셈)
			// a % b : 나머지
		}
	}
}