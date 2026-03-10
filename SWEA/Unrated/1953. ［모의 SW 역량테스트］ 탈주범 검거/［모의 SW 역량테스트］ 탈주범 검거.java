import java.util.*;

public class Solution {

    // 상, 하, 좌, 우 이동 방향
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    /*
    터널 타입별 이동 가능 방향

    방향 번호
    0 : 상
    1 : 하
    2 : 좌
    3 : 우
    */

    static int[][] tunnel = {
            {},                 // 0 : 터널 없음
            {0,1,2,3},          // 1 : 상, 하, 좌, 우
            {0,1},              // 2 : 상, 하
            {2,3},              // 3 : 좌, 우
            {0,3},              // 4 : 상, 우
            {1,3},              // 5 : 하, 우
            {1,2},              // 6 : 하, 좌
            {0,2}               // 7 : 상, 좌
    };

    static int N, M, R, C, L;   // 지도 크기, 시작 위치, 제한 시간
    static int[][] map;         // 터널 지도
    static boolean[][] visited; // 방문 체크

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();   // 테스트 케이스 수

        for(int t=1; t<=T; t++){

            // 지도 정보 입력
            N = sc.nextInt();   // 세로
            M = sc.nextInt();   // 가로
            R = sc.nextInt();   // 시작 행
            C = sc.nextInt();   // 시작 열
            L = sc.nextInt();   // 제한 시간

            map = new int[N][M];
            visited = new boolean[N][M];

            // 지도 입력
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    map[i][j] = sc.nextInt();
                }
            }

            // BFS 탐색 실행
            int result = find();

            System.out.println("#" + t + " " + result);
        }
    }

    // BFS로 탈주범이 갈 수 있는 위치 개수 찾기
    static int find(){

        Queue<int[]> q = new LinkedList<>();

        // 시작 위치 큐에 삽입 (행, 열, 시간)
        q.offer(new int[]{R,C,1});
        visited[R][C] = true;

        int count = 1; // 시작 위치도 포함

        // BFS 시작
        while(!q.isEmpty()){

            int[] now = q.poll(); // 현재 위치 꺼내기

            int r = now[0];       // 현재 행
            int c = now[1];       // 현재 열
            int time = now[2];    // 현재 시간

            // 제한 시간 도달
            // 이 위치에서는 더 이동할 수 없지만
            // 큐에 남아있는 다른 위치들은 계속 탐색해야 하므로 continue
            if(time == L) continue;

            int type = map[r][c]; // 현재 터널 타입

            // 현재 터널에서 이동 가능한 방향 확인
            for(int d : tunnel[type]){

                int nr = r + dr[d];
                int nc = c + dc[d];

                // 지도 범위 밖이면 패스
                if(nr<0 || nc<0 || nr>=N || nc>=M) continue;

                // 다음 위치에 터널이 없으면 이동 불가
                if(map[nr][nc] == 0) continue;

                // 이미 방문한 곳이면 패스
                if(visited[nr][nc]) continue;

                int nextType = map[nr][nc]; // 다음 터널 타입

                // 현재 이동 방향의 반대 방향 계산
                int opposite = 0;

                if(d == 0) opposite = 1;      // 상 -> 반대는 하
                else if(d == 1) opposite = 0; // 하 -> 반대는 상
                else if(d == 2) opposite = 3; // 좌 -> 반대는 우
                else if(d == 3) opposite = 2; // 우 -> 반대는 좌

                boolean canConnect = false;

                // 다음 터널이 반대 방향을 가지고 있는지 확인
                // 즉, 실제로 터널이 연결되는지 검사
                for(int nd : tunnel[nextType]){
                    if(nd == opposite){
                        canConnect = true;
                        break;
                    }
                }

                // 연결되지 않으면 이동 불가
                if(!canConnect) continue;

                // 방문 처리
                visited[nr][nc] = true;

                // 다음 위치를 큐에 추가 (시간 +1)
                q.offer(new int[]{nr,nc,time+1});

                // 이동 가능한 위치 개수 증가
                count++;
            }
        }

        // 최종 이동 가능한 위치 개수 반환
        return count;
    }
}