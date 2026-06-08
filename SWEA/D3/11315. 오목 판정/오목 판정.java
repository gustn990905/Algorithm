import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	// 오 하 하좌 하우
	static int[] dr = {0, 1, 1, 1};
	static int[] dc = {1, 0, -1, 1};
	
    public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			char[][] arr = new char[N][N];
			
			for(int r=0; r<N; r++) {
				String line = br.readLine();
				for(int c=0; c<N; c++) {
					arr[r][c] = line.charAt(c);
				}
			}
			
			boolean possible = false;
			
			loop:
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(arr[r][c] == 'o') {
						for(int d=0; d<4; d++) {
							int cnt = 1; // 현재 위치 포함
							int time = 0;
							
							while(true) {
								time++;
								int nr = r + dr[d]*time;
								int nc = c + dc[d]*time;
								
								if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
								
								// 빈칸이 들어오면 더 이상 연속되지 않음
								if(arr[nr][nc] == '.') break;
								else cnt++;
								
								if(cnt >= 5) {
									possible = true;
									break loop;
								}
							}
						}
					}
				}
			}
			if(possible) System.out.println("#" + t + " " + "YES");
			else System.out.println("#" + t + " " + "NO");
		}
	}
}