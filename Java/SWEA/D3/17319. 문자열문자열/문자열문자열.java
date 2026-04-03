import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt(); // 테스트 케이스 수
		
		for(int t=1; t<=TC; t++) {
			int N = sc.nextInt(); // 문자열의 길이
			String S = sc.next(); // 문자열
			char[] s = new char[N]; // 문자열 쪼개기
			
			for(int n=0; n<N; n++) {
				s[n] = S.charAt(n);
			}
			
			boolean possible = true;
			if(N % 2 == 1) {
				possible = false;
			} else {
				for(int i=0; i<N/2; i++) {
					if(s[i] != s[N/2+i]) {
						possible = false;
						break;
					}
				}
			}
			
			if(possible) System.out.println("#" + t + " " + "Yes");
			else System.out.println("#" + t + " " + "No");
		}
	}
}