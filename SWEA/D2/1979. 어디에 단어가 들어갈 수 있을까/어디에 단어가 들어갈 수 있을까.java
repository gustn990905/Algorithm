import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt(); // 퍼즐의 크기
			int K = sc.nextInt(); // 퍼즐에 들어갈 단어의 길이
			
			int[][] puzzle = new int[N][N];
			
			// 각 길이의 단어들이 몇 개씩 들어갈 수 있는지 확인할 배열
			// 1부터 최대 N의 길이만큼의 퍼즐 조각이 들어갈 수 있어서 N+1
			int[] result = new int[N+1];
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					puzzle[r][c] = sc.nextInt();
				}
			}
			
			// 퍼즐 조각이 가로로 들어가는 경우
			for(int r=0; r<N; r++) {
				boolean possible = false;
				int put = 0;
				for(int c=0; c<N; c++) {
					// 흰색인 1인 경우에는 possible=true
					// 가능한 퍼즐 조각 하나 추가
					if(puzzle[r][c] == 1) {
						possible = true;
						put++;
					} 
					
					//검정색인 0을 만나면 바로 possible=false
					else {
						possible = false;
					}
					
					// 검정색을 만나자마자 그 동안 가능했던 길이를 result에 저장
					// put 초기화 
					if(!possible) {
						result[put]++;
						put = 0;
					}
				}
				
				// c의 끝까지 확인한 경우 마지막 숫자가 1로 끝나면 possible로 끝남
				// 이 때의 값도 저장
				if(possible) {
					result[put]++;
					put = 0;
				}
			}
			
			// 퍼즐 조각이 세로로 들어가는 경우
			for(int c=0; c<N; c++) {
				boolean possible = false;
				int put = 0;
				for(int r=0; r<N; r++) {
					if(puzzle[r][c] == 1) {
						possible = true;
						put++;
					} else possible= false;
					
					if(!possible) {
						result[put]++;
						put = 0;
					}
				}
				if(possible) {
					result[put]++;
					put = 0;
				}
			}
			
			System.out.println("#" + t + " " + result[K]);
		}
	}
}