import java.util.Scanner;

public class Solution {
    
    static int N, M;
    static boolean[][] graph;  // 인접 행렬로 그래프 표현
    static boolean[] visited;  // 방문 여부 체크
    static int maxLen;         // 최장 경로 길이 저장
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();
            
            // 매 테스트케이스마다 초기화
            graph   = new boolean[N + 1][N + 1];
            visited = new boolean[N + 1];
            maxLen  = 1; // 정점이 1개여도 경로 길이는 최소 1
            
            // 간선 정보 입력
            for (int i = 0; i < M; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                graph[x][y] = true;
                graph[y][x] = true; // 무방향이므로 양쪽 모두 표시
            }
            
            // 모든 정점을 시작점으로 DFS 탐색
            // 어떤 정점에서 시작하느냐에 따라 최장경로가 달라질 수 있음
            for (int i = 1; i <= N; i++) {
                visited[i] = true;       // 시작 정점 방문 처리
                dfs(i, 1);               // DFS 시작 (현재 경로 길이 = 1)
                visited[i] = false;      // 다음 시작점을 위해 초기화
            }
            
            System.out.println("#" + tc + " " + maxLen);
        }
    }
    
    static void dfs(int cur, int len) {
        
        // 현재 경로 길이로 최대값 갱신
        maxLen = Math.max(maxLen, len);
        
        // 현재 정점(cur)과 연결된 모든 정점 탐색
        for (int next = 1; next <= N; next++) {
            
            // 1. 간선이 존재하는지 확인
            // 2. 아직 방문하지 않은 정점인지 확인
            if (graph[cur][next] && !visited[next]) {
                
                visited[next] = true;        // 방문 처리
                dfs(next, len + 1);          // 다음 정점으로 이동
                visited[next] = false;       // 백트래킹: 방문 취소
            }
        }
    }
}