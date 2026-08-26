import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {

    static int[] tree;
    static List<Integer>[] level;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int K = Integer.parseInt(br.readLine());

            // 전체 노드 개수 = 2^K - 1
            int N = (int) Math.pow(2, K) - 1;

            tree = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                tree[i] = Integer.parseInt(st.nextToken());
            }

            level = new ArrayList[K];

            for (int i = 0; i < K; i++) {
                level[i] = new ArrayList<>();
            }

            search(0, N - 1, 0);

            System.out.print("#" + tc + " ");

            for (int i = 0; i < K; i++) {
                for (int num : level[i]) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }
    static void search(int start, int end, int depth) {

        if (start > end) {
            return;
        }

        // 가운데 값이 현재 부모
        int mid = (start + end) / 2;

        level[depth].add(tree[mid]);

        // 왼쪽
        search(start, mid - 1, depth + 1);

        // 오른쪽
        search(mid + 1, end, depth + 1);
    }
}