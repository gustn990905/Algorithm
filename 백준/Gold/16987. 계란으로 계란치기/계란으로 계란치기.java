import java.util.Scanner;

public class Main {

	static int N;
	static int[][] egg; // 계란의 내구력과 무게를 입력 받을 곳
	static int cnt; // 깨진 계란의 수
	static int maxCnt; // 깨진 계란의 최대 수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		egg = new int[N][2];

		for (int n = 0; n < N; n++) {
			egg[n][0] = sc.nextInt();
			egg[n][1] = sc.nextInt();
		}

		maxCnt = 0;

		breakEgg(0);
		System.out.println(maxCnt);
	}

	static void breakEgg(int idx) {
		// 기준 계란이 맨 오른쪽 계란인 경우 종료
		if (idx == N) {
			cnt = 0;
			for (int n = 0; n < N; n++) {
				// 내구력이 0이하인 계란 = 깨진 계란
				if (egg[n][0] <= 0)
					cnt++;
			}
			
			// 최대 계란 수 갱신
			if(maxCnt < cnt) maxCnt = cnt;
			return;
		}
		
		// 현재 계란이 깨진 계란이면 다음으로 넘어가기
		// 현재 계란이 깨진 계란이 아니라면 동작하지 않기 때문에 
		if (egg[idx][0] <= 0) {
			breakEgg(idx+1);
			return;
		}
		
		boolean possible = false; // 계란을 칠 수 있는지 없는지 확인
		for(int i=0; i<N; i++) {
			if(idx==i || egg[i][0] <= 0) continue;
			
			possible = true;
			
			// 계란의 내구력 감소
			egg[idx][0] -= egg[i][1];
			egg[i][0] -= egg[idx][1];
			
			// 계란을 치면 있으면 다음 단계로 넘어가기
			breakEgg(idx+1);
			
			// 백트랙킹
			egg[idx][0] += egg[i][1];
			egg[i][0] += egg[idx][1];
			
		}
		
		if(!possible) {
			breakEgg(idx+1);
		}
	}

}