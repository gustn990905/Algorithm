import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N + 1];
        int[] psum = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
            psum[i] = psum[i - 1] + arr[i];
        }

        int[][] dp = new int[N + 1][M + 1];

        for(int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = 0;

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {

                for(int k = 0; k < i; k++) {

                    if(dp[k][j - 1] == Integer.MAX_VALUE)
                        continue;

                    int lastSum = psum[i] - psum[k];

                    dp[i][j] = Math.min(
                        dp[i][j],
                        Math.max(dp[k][j - 1], lastSum)
                    );
                }
            }
        }

        System.out.println(dp[N][M]);
    }
}