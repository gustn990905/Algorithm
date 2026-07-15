import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t=1; t<=T; t++) {
            int N = sc.nextInt(); // 첫 번째 카드
            int M = sc.nextInt(); // 두 번째 카드

            // 더한 값 저장 배열
            int[] sum = new int[N+M+1];

            for(int n=1; n<=N; n++) {
                for(int m=1; m<=M; m++) {
                    sum[n+m]++;
                }
            }

            int max = Integer.MIN_VALUE;
            for(int i=2; i<sum.length; i++) {
                max = Math.max(max, sum[i]);
            }

            StringBuilder answer = new StringBuilder();

            answer.append("#" + t + " ");
            for(int i=2; i<sum.length; i++) {
                if(max == sum[i]) answer.append(i + " ");
            }
            System.out.println(answer);
        }
    }
}