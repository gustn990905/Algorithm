import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			
			int[][] map = new int[N][N];
			for(int r=0; r<N; r++) {
				String line = sc.next();
				for(int c=0; c<N; c++) {
					map[r][c] = line.charAt(c) - '0';
				}
			}
			
			int sum = 0;
			for(int r=0; r<=N/2; r++) {
				for(int c=N/2-r; c<=N/2+r; c++) {
					sum += map[r][c];
				}
			}
			
			for(int r=N/2+1; r<N; r++) {
				for(int c=N/2-(N-1-r); c<=N/2+(N-1-r); c++) {
					sum += map[r][c];
				}
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}
}