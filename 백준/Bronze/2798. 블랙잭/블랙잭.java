import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int maxResult;
	static int[] card; // 카드 값 저장 배열
	static boolean[] selected; // 해당 카드를 선택했는지 여부
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		card = new int[N];
		for(int n=0; n<N; n++) {
			card[n] = sc.nextInt();
		}
		
		selected = new boolean[N];
		
		maxResult = 0;
		
		selectCard(0, 0);
		System.out.println(maxResult);
	}
	
	/*
	 * select : 현재까지 선택한 카드 개수
	 * idx    : 현재 검사 중인 카드 인덱스
	 */
	public static void selectCard(int select, int idx) {
		// 3장을 모두 선택했을 경우
		if(select == 3) {
			int result = 0;
			for(int n=0; n<N; n++) {
				if(selected[n]) {
					result += card[n];
				}
			}
			// M을 넘지 않으면 최대값 갱신
			if(result <= M) {
				maxResult = Math.max(maxResult, result);
			}
			return;
		}
		
		if(idx == N) {
			return;
		}
		
		// 현재 카드를 선택하는 경우
		selected[idx] = true;
		selectCard(select+1, idx+1);
		
		selected[idx] = false;
		selectCard(select, idx+1);
	}
}