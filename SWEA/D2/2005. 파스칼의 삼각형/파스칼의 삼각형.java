import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			// 파스칼의 삼각형을 저장할 2차원 배열
			// 인덱스를 1부터 사용하기 위해 N+1 크기로 생성
			int[][] arr = new int [N+1][N+1];
			
			arr[1][1] = 1;
			
			// 파스칼의 삼각형 규칙 : arr[i][j] = arr[i-1][j-1] + arr[i-1][j]
			for(int i=2; i<N+1; i++) {
				for(int j=1; j<=i; j++) {
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				}
			}
			
			System.out.println("#" + t);
			// 0이 아닌 값만 출력
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					if(arr[i][j] != 0) {
						System.out.print(arr[i][j] + " ");
					}
				}
				System.out.println();
			}
		}
	}
}
