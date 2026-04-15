import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static int cnt;
	
	static boolean[] col;
	static boolean[] diag1; // 대각선 1
	static boolean[] diag2; // 대각선 2
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		col = new boolean[N];
		
		// N*N 배열에서 대각선의 개수는 2*N-1개지만 그냥 2*N으로 둠
		diag1 = new boolean[2*N]; 
		diag2 = new boolean[2*N];
		
		cnt = 0;
		find(0);
		
		System.out.println(cnt);
		
	}
	
	static void find(int row) {
		// 각 row에 모두 queen이 있는 경우
		if(row == N) {
			cnt++;
			return;
		}
		
		for(int c=0; c<N; c++) {
			if(col[c] || diag1[row+c] || diag2[row-c+N]) continue;
			
			col[c] = true;
			diag1[row+c] = true;
			diag2[row-c+N] = true;
			
			find(row+1);
			
			col[c] = false;
			diag1[row+c] = false;
			diag2[row-c+N] = false;
		}
	}
}
