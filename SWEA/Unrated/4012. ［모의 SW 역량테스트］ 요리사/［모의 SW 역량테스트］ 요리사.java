import java.util.Scanner;

public class Solution {
	
	static int N;
	static int[][] ingredient;
	static boolean[] selected;
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			ingredient = new int[N][N];
			selected = new boolean[N];
			min = Integer.MAX_VALUE;
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					ingredient[r][c] = sc.nextInt();
				}
			}
			food(0, 0);
			System.out.println("#" + t + " " + min);
		}
	}
	
	// select : 현재까지 선택한 재료 개수
	// count : 현재 인덱스 (0 ~ N-1)
	public static void food(int select, int count) {
		// N/2개를 선택했다면 팀 구성이 완료된 것
		if(select == N/2) {
			cal();
			return;
		}
		// 모든 재료를 다 확인했으면 종료
		if(count == N) return;
		
		// 현재 재료를 A팀에 선택하는 경우
		selected[count] = true;
		// 선택 개수 증가, 다음 인덱스로 이동
		food(select+1, count+1);
		
		// 현재 재료를 선택하지 않는 경우 (B팀으로)
		selected[count] = false;
		// 선택 개수 유지, 다음 인덱스로 이동
		food(select, count+1);
	}
	
	public static void cal() {
		
		int A = 0;
		int B = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(selected[i] && selected[j]) {
					A += ingredient[i][j];
				}
				else if(!selected[i] && !selected[j]) {
					B += ingredient[i][j];
				}
			}
		}
		
		min = Math.min(min, Math.abs(A-B));
	}
}