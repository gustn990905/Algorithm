import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=T; t++) {
			
			sb.append("#").append(t).append(" " );
			
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
			
			int sR = 0;
			int sC = 0;
			
			// 필드 채우기
			for(int r=0; r<N; r++) {
				String line = br.readLine();
				for(int c=0; c<N; c++) {
					map[r][c] = line.charAt(c);
					
					// 시작점 찾기
					if(map[r][c] == 'X') {
						sR = r;
						sC = c;
					}
				}
			}
						
			int Q = Integer.parseInt(br.readLine()); // 조종 횟수 
			for(int q=0; q<Q; q++) {

				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int dir = 1; // 시작 방향
				int startR = sR;
				int startC = sC;
				
				int c = Integer.parseInt(st.nextToken());
				String fullCommand = st.nextToken();
				
				for(int i=0; i<c; i++) {
					char go = fullCommand.charAt(i);
					
					// 상: 1, 오: 2, 하: 3, 좌: 4
					if(go == 'R') {
						if(dir==1) dir = 2;
						else if(dir == 2) dir = 3;
						else if(dir == 3) dir = 4;
						else dir = 1;
					} else if(go == 'L') {
						if(dir==1) dir = 4;
						else if(dir == 2) dir = 1;
						else if(dir == 3) dir = 2;
						else dir = 3;
					} else {
						if(dir == 1) {
							startR--;
							if(startR < 0 || map[startR][startC] == 'T') {
								startR++;
								continue;
							}
						} else if(dir == 2) {
							startC++;
							if(startC >= N || map[startR][startC] == 'T') {
								startC--;
								continue;
							}
						} else if(dir == 3) {
							startR++;
							if(startR >= N || map[startR][startC] == 'T') {
								startR--;
								continue;
							}
						} else {
							startC--;
							if(startC < 0 || map[startR][startC] == 'T') {
								startC++;
								continue;
							}
						}
					}
				}
				if (map[startR][startC] == 'Y')
					sb.append(1).append(" ");
				else
					sb.append(0).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}