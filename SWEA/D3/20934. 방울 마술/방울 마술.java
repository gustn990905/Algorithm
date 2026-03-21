import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 수
		for (int t = 1; t <= T; t++) {
			String S = sc.next(); // 컵과 방울의 위치
			int K = sc.nextInt(); // 방울이 울린 횟수
			
			int bell = 0; // 방울의 위치
			
			// 처음 방울의 위치 찾기
			for(int s=0; s<S.length(); s++) {
				if(S.charAt(s) == 'o') {
					bell = s;
				}
			}
			
			// 방울이 울린 횟수가 0이 될때까지 
			// 방울이 있을 확률이 가장 높은 컵의 위치 중 가장 왼쪽 찾기
			while(K > 0) {
				if(bell == 0) {
					bell++;
					K--;
				} else {
					bell--;
					K--;
				}
			}
			
			System.out.println("#" + t + " " + bell);
		}
	}
}