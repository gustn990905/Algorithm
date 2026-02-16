import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			// 원본 행렬
			int[][] arr = new int[N][N];
			// 90도, 180도, 270도 회전 결과 저장 배열
			int[][] arr90 = new int[N][N];
			int[][] arr180 = new int[N][N];
			int[][] arr270 = new int[N][N];
			
			// 원본 입력
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			// 회전 계산
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					arr90[c][N-1-r] = arr[r][c];
					arr180[N-1-r][N-1-c] = arr[r][c];
					arr270[N-1-c][r] = arr[r][c];
				}
			}
			System.out.println("#" + t);
			// 한 줄에 90도, 180도, 270도 결과를 나란히 출력
			for(int r=0; r<N; r++) {
				// 90도 회전 행 출력
				for(int c=0; c<N; c++) {
					System.out.print(arr90[r][c]);
				} System.out.print(" ");
				// 180도 회전 행 출력
				for(int c=0; c<N; c++) {
					System.out.print(arr180[r][c]);
				} System.out.print(" ");
				// 270도 회전 행 출력
				for(int c=0; c<N; c++) {
					System.out.print(arr270[r][c]);
				}
				System.out.println();
			}
		}
	}
}