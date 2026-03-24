import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			String S = sc.next();
			
			int a = S.length(); // 문자열 S의 길이
			int b = (a-1) / 2; // 회문의 회문을 판단할 조건
			
			boolean possible = true;
			
			for(int i=0; i<b; i++) {
				if(S.charAt(i) != S.charAt(a-1-i)) {
					possible = false;
					break;
				}
			}
			
			for(int i=0; i<b/2; i++) {
				if(S.charAt(i) != S.charAt(b-1-i)) {
					possible = false;
					break;
				}
			}
			
			for(int i=b/2; i<(a-b/2)/2; i++) {
				if(S.charAt(i)!=S.charAt(a-1-i)) {
					possible = false;
					break;
				}
			}
			
			if(!possible) System.out.println("#" + t + " " + "NO");
			else System.out.println("#" + t + " " + "YES");
		}
	}
}