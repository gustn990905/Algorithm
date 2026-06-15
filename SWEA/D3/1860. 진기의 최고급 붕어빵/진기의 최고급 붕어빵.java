import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 손님 수
			int M = sc.nextInt(); // 붕어빵을 만드는 시간
			int K = sc.nextInt(); // 만들 수 있는 붕어빵의 수

			int[] guests = new int[N];
			for (int i = 0; i < N; i++) {
				guests[i] = sc.nextInt();
			}

			// 빨리 도착하는 손님 순서로 정렬
			Arrays.sort(guests);

			boolean possible = true;
			
			for(int i=0; i<N; i++) {
				int time = guests[i];
				
				// time까지 만든 붕어빵 수
				int bread = (time/M) * K;
				
				if(bread < i+1) {
					possible = false;
					break;
				}
			}
			
			System.out.println("#" + t + " " + (possible ? "Possible" : "Impossible"));
		}
	}
}