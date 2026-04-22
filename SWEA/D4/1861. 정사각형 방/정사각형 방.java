import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static int N;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int roomCnt;
	
	static int[][] room;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테스트 케이스 수 입력
		for(int t=1; t<=T; t++) {
			N = sc.nextInt(); // 방의 크기
			
			room = new int[N][N];
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					room[r][c] = sc.nextInt();
				}
			}
			
			int roomNum = 0;
			int maxResult = 0;
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					roomCnt = 1;
					int result = BFS(r, c, 1);
					
					if (result > maxResult) {
					    roomNum = room[r][c];
					    maxResult = result;
					} else if (result == maxResult) {
					    roomNum = Math.min(roomNum, room[r][c]);
					}
				}
			}
			
			System.out.println("#" + t + " " + roomNum + " " + maxResult);
		}
	}
	
	static int BFS(int r, int c, int cnt) {
		
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {r, c, cnt});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			int curR = cur[0];
			int curC = cur[1];
			int curCnt = cur[2];
			
			for(int i=0; i<4; i++) {
				int nr = curR + dr[i];
				int nc = curC + dc[i];
				
				// 범위를 벗어나면 continue
				if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
				
				if(room[nr][nc] - room[curR][curC] == 1) {
					q.add(new int[] {nr, nc, curCnt+1});
				}
			}
			roomCnt = Math.max(roomCnt, curCnt);
		}
		return roomCnt;
	}
}