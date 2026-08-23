class Solution {
    public int solution(int n) {
        int right = 1;
        int left = 1;
        int sum = 1;
        int answer = 0;

        while(right <= n) {
            if(sum == n) {
                answer++;

                // 가장 왼쪽 숫자 증가
                sum -= left;
                left++;
            }

            // 합이 n보다 작으면
            else if(sum < n) {
                right++;
                sum += right;
            }

            else {
                // 합이 n보다 크면
                sum -= left;
                left++;
            }
        }

        return answer;
    }
}