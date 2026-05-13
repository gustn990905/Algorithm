import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 스위치 개수
			
			// 조작 전 스위치 상태
			int[] origin = new int[N];
			for(int i=0; i<N; i++) {
				origin[i] = sc.nextInt();
			}
			
			// 조작 후 스위치 상태
			int[] result = new int[N];
			for(int i=0; i<N; i++) {
				result[i] = sc.nextInt();
			}
			
			int cnt = 0; // 조작 횟수
			
			for(int i=0; i<N; i++) {
				// 조작 전 스위치와 조작 후 스위치의 같은 위치지만 값이 다른 경우
				if(origin[i] != result[i]) {
					for(int j=i; j<N; j++) {
						if(origin[j] == 0) origin[j] = 1;
						else origin[j] = 0;
					}
					
					cnt++;
				}
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
}