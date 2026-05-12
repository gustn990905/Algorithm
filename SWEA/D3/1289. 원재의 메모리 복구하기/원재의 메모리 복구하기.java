import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			String target = sc.next();
			
			int now = 0; // 현재 메모리의 끝까지 덮어씌울 값
			
			int cnt = 0; // 수정 횟수
			
			for(int i=0; i<target.length(); i++) {
				int m = target.charAt(i) - '0';
				
				if(now != m) {
					now = Math.abs(now-1); // 0이면 1로 바뀌고 1이면 0으로 바뀜
					cnt++;
				}
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
}