import java.util.Arrays;

class Solution {
    public int[] solution(int N, int[] stages) {
        double[][] cal = new double[N][2];
        int[] result = new int[N];

        // N번 반복
        for (int i = 1; i <= N; i++) {
            int challenge = 0;
            int fail = 0;

            for (int j = 0; j < stages.length; j++) {
                if(stages[j] >= i) challenge++;

                if(stages[j] == i) fail++;
            }

            double failRate = 0;

            if(challenge != 0) failRate = (double) fail / challenge;

            // 스테이지 번호 저장
            cal[i-1][0] = i;

            // 실패율 저장
            cal[i-1][1] = failRate;
        }

        // 정렬
        Arrays.sort(cal, (a, b) -> {
            // 같은 값이면 스테이지 idx 오름차순
            if(b[1] == a[1]) return (int)(a[0] - b[0]);

            // 실패율 내림차순
            return Double.compare(b[1], a[1]);
        });

        for (int i = 0; i < N; i++) {
            result[i] = (int) cal[i][0];
        }

        return result;
    }
}