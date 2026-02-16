import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			// 첫 번째 시간 (시, 분)
			int h1 = sc.nextInt();
			int m1 = sc.nextInt();
			
			// 두 번째 시간 (시, 분)
			int h2 = sc.nextInt();
			int m2 = sc.nextInt();
			
			// 결과 시간 저장 변수
			int h = 0;
			int m = 0;
			
			// 분 계산
			// 분의 합이 60 미만이면 그대로 저장
			if(m1 + m2 < 60) {
				m = m1 + m2; 
			} 
			// 60 이상이면 60을 빼고, 시를 1 증가
			else {
				m = m1 + m2 - 60;
				h++;
			}
			
			// 시 계산
			if(h + h1 + h2 <= 12) {
				h = h + h1 + h2;
			} else {
				h = h + h1 + h2 - 12;
			}
			
			System.out.println("#" + t + " " + h + " " + m);
		}
	}
}