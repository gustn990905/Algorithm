import java.util.LinkedList;
import java.util.Queue;

class Solution {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        
        while(!q.isEmpty()) {
        	int[] curr = q.poll();
        	int r = curr[0];
        	int c = curr[1];
        	
        	for(int d=0; d<4; d++) {
        		int nr = r + dr[d];
        		int nc = c + dc[d];
        		
        		if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
        		
        		// 벽이거나 이미 방문한 경우
        		if(maps[nr][nc] != 1) continue;
        		
        		maps[nr][nc] = maps[r][c] + 1;
        		q.add(new int[] {nr, nc});
        	}
        }
        return maps[n-1][m-1] == 1 ? -1 : maps[n-1][m-1];
    }
}