class Solution {
	
	int answer = Integer.MAX_VALUE;
	int[][] info;
	int n, m;
	boolean[][][] visited;
	
    public int solution(int[][] info, int n, int m) {
    	
    	this.info = info;
    	this.n = n;
    	this.m = m;
    	
    	visited = new boolean[41][121][121];
    	
    	dfs(0, 0, 0);
        
    	if(answer == Integer.MAX_VALUE) answer = -1;
    	
        return answer;
    }
    
    void dfs(int idx, int a, int b) {
    	// 경찰에 검거
    	if(a >=n || b >= m) return;
    	
    	// 이미 방문한 상태인지 확인
    	if(visited[idx][a][b]) return;
    	
    	visited[idx][a][b] = true;
    	
    	// 저장된 answer보다 a가 커버리면 중단
    	if(a >= answer) return;
    	
    	// 모든 물건을 처리한 경우
    	if(idx == info.length) {
    		answer = Math.min(answer, a);
    		return;
    	}
    	
    	// A가 훔치는 경우
    	dfs(idx+1, a+info[idx][0], b);
    	
    	// B가 훔치는 경우
    	dfs(idx+1, a, b+info[idx][1]);
    }
}