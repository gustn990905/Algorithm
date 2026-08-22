import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());

            int left = 1;
            int right =1;

            int sum = 1;
            int count = 0;

            while(right <= N) {
                // 현재 연속된 수들의 합이 N과 같으면
                if(sum == N) {
                    count++;
                    
                    // 가장 왼쪽 숫자를 제거
                    sum -= left;
                    left++;
                }
                
                // 합이 N보다 작으면
                else if(sum < N) {
                    // 오른쪽 범위 늘리기
                    right++;
                    sum += right;
                }
                
                // 합이 N보다 크면
                else {
                    sum -= left;
                    left++;
                }
            }
            System.out.println("#" + t + " " + count);
        }
    }
}