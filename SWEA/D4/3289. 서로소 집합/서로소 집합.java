import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 부모 배열
            // 1부터 시작
            p = new int[n+1];

            // 처음에는 자기 자신이 대표
            for(int i=1; i<=n; i++) {
                p[i] = i;
            }

            StringBuilder sb = new StringBuilder();

            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());

                int command = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                // 두 집합 합치기
                if(command == 0) {
                    union(a, b);
                }

                // 같은 집합인지 확인
                else {
                    if(findSet(a) == findSet(b)) sb.append(1);
                    else sb.append(0);
                }
            }
            System.out.println("#" + t + " " + sb);
        }
    }
    // 두 집합 합치기
    static void union(int a, int b) {
        int pa = findSet(a);
        int pb = findSet(b);

        if(pa != pb) {
            p[pb] = pa;
        }
    }

    // 두 집합 합치기
    static int findSet(int x) {
        if(x != p[x]) {
            p[x] = findSet(p[x]);
        }

        return p[x];
    }
}