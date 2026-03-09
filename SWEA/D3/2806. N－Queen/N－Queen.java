import java.util.Scanner;

public class Solution {
	
	static int N; 
	static boolean[] usedCol; //해당열을 사용했는가
	static boolean[] usedDiag1; // (우상향)대각선 사용여부 row+col이 같음
	static boolean[] usedDiag2; // (좌상향)대각선 사용여부 row-col이 같음(음수가 나오므로 N-1 만큼 쉬프트)
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			
			usedCol = new boolean[N];
			usedDiag1 = new boolean[2*N-1];
			usedDiag2 = new boolean[2*N-1];
			
			result = 0;
			possible(0);
			System.out.println("#" + t + " " + result);
		}
	}
	
	public static void possible(int row) {
		if(row == N) {
			result++;
			return;
		}
		
		//재귀파트
		//row 행에 c 열 위치에 두겠다
		for(int c=0; c<N; c++) {
			int d1 = row+c; // 우상향 대각선 번호
			int d2 = row - c + N - 1; // 좌상향 대각선 번호
			
			//이미사용중인 열, 대각선인 경우는 다음 스텝으로 넘어가기
			if(usedCol[c] || usedDiag1[d1] || usedDiag2[d2]) {
				continue;
			}
			
			usedCol[c] = true;
			usedDiag1[d1] = true;
			usedDiag2[d2] = true;
			
			possible(row+1);
			
			usedCol[c] = false;
			usedDiag1[d1] = false;
			usedDiag2[d2] = false;
		}
	}
}