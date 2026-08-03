class Solution {
    public int solution(int[][] signals) {
         // 각 신호등 전체 주기의 최소공배수를 저장
        long limit = 1;

        // 모든 신호등의 전체 주기를 이용해 최소공배수
        for (int i = 0; i < signals.length; i++) {

            // 초록불 시간
            int green = signals[i][0];

            // 노란불 시간
            int yellow = signals[i][1];

            // 빨간불 시간
            int red = signals[i][2];

            // 현재 신호등의 전체 주기
            int period = green + yellow + red;

            // 지금까지의 최소공배수와 현재 주기의 최소공배수
            limit = lcm(limit, period);
        }

        for (long time = 1; time <= limit; time++) {

             // 현재 시간에 모든 신호등이 노란불이라고 가정
            boolean allYellow = true;

            // 모든 신호등을 하나씩 확인한다.
            for (int i = 0; i < signals.length; i++) {

                int green = signals[i][0];
                int yellow = signals[i][1];
                int red = signals[i][2];

                // 현재 신호등의 전체 주기
                int period = green + yellow + red;
                
                long position = (time - 1) % period;
                
                 // 이 조건을 만족하지 않으면 노란불 아님
                if (position < green || position >= green + yellow) {
                    allYellow = false;
                    break;
                }
            }
            
            if (allYellow) {
                return (int) time;
            }
        }

        // 최소공배수 시간까지 없었다면 -1
        return -1;
    }

    // 최대공약수 구하기
    private long gcd(long a, long b) {
        while (b != 0) {
            long remainder = a % b;
            a = b;
            b = remainder;
        }

        return a;
    }

    // 최소공배수 구하기
    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}