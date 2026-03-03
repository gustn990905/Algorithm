import java.util.Scanner;

public class Solution {

    static int N;
    static int[] office = new int[2];
    static int[] house = new int[2];
    static int[] customer;
    static boolean[] visited;
    static int min; // 최소 거리 저장

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {

            N = sc.nextInt();

            // 회사 좌표
            for (int i = 0; i < 2; i++) {
                office[i] = sc.nextInt();
            }

            // 집 좌표
            for (int i = 0; i < 2; i++) {
                house[i] = sc.nextInt();
            }

            // 고객 좌표
            customer = new int[2 * N];
            for (int i = 0; i < 2 * N; i++) {
                customer[i] = sc.nextInt();
            }

            visited = new boolean[N];
            min = Integer.MAX_VALUE;

            // 시작: 회사 위치에서 출발
            dfs(0, office[0], office[1], 0);

            System.out.println("#" + t + " " + min);
        }
    }

    // depth: 방문한 고객 수
    // nowX, nowY: 현재 위치
    // sum: 현재까지 이동 거리
    static void dfs(int depth, int nowX, int nowY, int sum) {

        // 가지치기 (이미 최소보다 크면 탐색 중단)
        if (sum >= min) return;

        // 모든 고객 방문 완료
        if (depth == N) {
            // 마지막에 집으로 이동
            sum += Math.abs(nowX - house[0]) + Math.abs(nowY - house[1]);
            min = Math.min(min, sum);
            return;
        }

        // 아직 방문하지 않은 고객 선택
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;

                int nextX = customer[2 * i];
                int nextY = customer[2 * i + 1];

                int distance = Math.abs(nowX - nextX) + Math.abs(nowY - nextY);

                dfs(depth + 1, nextX, nextY, sum + distance);

                visited[i] = false; // 백트래킹
            }
        }
    }
}