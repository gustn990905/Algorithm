import java.util.Scanner;

public class Solution {

    static int N, X, M;
    static int[] arr;
    static int[] best;
    static int[][] record;
    static int maxSum;

    static void dfs(int idx) {

        if (idx == N) {

            // 기록 검사
            for (int i = 0; i < M; i++) {

                int l = record[i][0] - 1;
                int r = record[i][1] - 1;
                int s = record[i][2];

                int sum = 0;

                for (int j = l; j <= r; j++)
                    sum += arr[j];

                if (sum != s)
                    return;
            }

            int total = 0;
            for (int i = 0; i < N; i++)
                total += arr[i];

            if (total > maxSum) {
                maxSum = total;
                best = arr.clone();
            }

            else if (total == maxSum) {

                for (int i = 0; i < N; i++) {

                    if (arr[i] < best[i]) {
                        best = arr.clone();
                        break;
                    }
                    else if (arr[i] > best[i])
                        break;
                }
            }

            return;
        }

        for (int i = 0; i <= X; i++) {
            arr[idx] = i;
            dfs(idx + 1);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {

            N = sc.nextInt();
            X = sc.nextInt();
            M = sc.nextInt();

            arr = new int[N];
            best = null;
            maxSum = -1;

            record = new int[M][3];

            for (int i = 0; i < M; i++) {
                record[i][0] = sc.nextInt();
                record[i][1] = sc.nextInt();
                record[i][2] = sc.nextInt();
            }

            dfs(0);

            System.out.print("#" + t + " ");

            if (best == null)
                System.out.println(-1);

            else {

                for (int i = 0; i < N; i++)
                    System.out.print(best[i] + " ");

                System.out.println();
            }
        }
    }
}