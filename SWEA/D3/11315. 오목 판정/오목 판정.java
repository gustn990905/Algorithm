import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		// 8방향 탐색을 위한 방향 배열 (상, 하, 좌, 우 + 대각선)
		int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			char[][] map = new char[N][N];
			
			for(int r=0; r<N; r++) {
				String line = br.readLine().trim();
				for(int c=0; c<N; c++) {
					map[r][c] = line.charAt(c);
				}
			}
			
			// 결과 저장 (5목 이상이면 갱신됨)
			int result = 0;
			loop: // 전체 탐색 중 조건 만족 시 바로 탈출하기 위한 라벨
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c] == 'o') {
						for(int i=0; i<8; i++) {
							int cnt = 1; // 현재 위치 포함 1개부터 시작
							int time = 0;
							while(true) {
								time++;
								int nr = r + dr[i]*time;
								int nc = c + dc[i]*time;
								
								if(nr<0 || nr>=N || nc<0 || nc>=N) break;
								
								// 빈칸이면 더 이상 연속되지 않으므로 종료
								if(map[nr][nc] == '.') break;
								else cnt++;
								
								if(cnt >= 5) {
									result = cnt;
									break loop;
								}
							}
						}
					}
				}
			}
			
			if(result >= 5) System.out.println("#" + t + " " + "YES");
			else System.out.println("#" + t + " " + "NO");
		}
	}
}