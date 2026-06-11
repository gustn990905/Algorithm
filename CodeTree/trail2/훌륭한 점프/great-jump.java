import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    static int N, K;
    static int[] arr;
    static int[] dp;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        K = sc.nextInt();
        
        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
        
        dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // 첫 번째 돌은 무조건 밟음
        dp[0] = arr[0];
        
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j <= Math.min(N - 1, i + K); j++) {
                dp[j] = Math.min(dp[j],
                        Math.max(dp[i], arr[j]));
            }
        }

        System.out.println(dp[N - 1]);
    }
}