import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			
			int speed = 0; // 현재 속도
			int distance = 0; // 총 이동 거리
			
			// N개의 명령 처리
			for(int n=0; n<N; n++) {
				int c = sc.nextInt();
				
				// 0 : 속도 유지
				if(c == 0) {
					distance += speed; // 현재 속도만큼 이동
				} 
				
				// 1 : 가속
				else if(c == 1){
					int c1 = sc.nextInt();
					speed += c1;
					distance += speed;
				} 
				
				// 2 : 감속
				else {
					int c2 = sc.nextInt();
					speed -= c2;
					
					// 속도는 음수가 될 수 없음
					if(speed <= 0) {
						speed = 0;
					} else {
						distance += speed;
					}
				}
			}
			System.out.println("#" + t + " " + distance);
		}
	}
}