import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        /*
         * 1. while(i != Math.sqrt(P)) 를 사용했음
         *    -> Math.sqrt(P)는 double(실수)
         *    -> i는 정수(int)
         *    -> 실수와 정수를 != 로 비교하면
         *      대부분 절대 같아질 수 없음
         *    -> 무한루프 발생
         *    -> 시간초과 -> 런타임 에러
         *
         * 2. i를 P까지 반복했었음
         *    -> P 최대 10^12
         *    -> 1조 번 반복
         *    -> 절대 시간 내에 못 끝남
         *
         * -> 지금 코드는 위 문제들을 모두 해결한 상태
         */

        for(int t = 1; t <= T; t++) {

            long S = sc.nextLong(); // 두 수의 합
            long P = sc.nextLong(); // 두 수의 곱

            boolean go = false; // 조건을 만족하는 (N, M) 존재 여부

            // P의 제곱근 계산
            // 약수는 √P 기준으로 대칭이므로
            // √P까지만 반복하면 모든 약수 쌍을 확인 가능
            long limit = (long)Math.sqrt(P);

            // 1부터 √P까지 반복
            for(long i = 1; i <= limit; i++) {

                // i가 P의 약수가 아니면 건너뜀
                if(P % i != 0) continue;

                // i가 약수라면
                // (i, P/i)는 하나의 약수 쌍
                long N = i;
                long M = P / i;

                // 합이 S인지 확인
                if(N + M == S) {
                    go = true;  // 조건 만족
                    break;      // 더 볼 필요 없음
                }
            }

            // 결과 출력
            if(go) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}