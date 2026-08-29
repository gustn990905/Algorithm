import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=10; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] height = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=0; i<N; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;

            // 양쪽으로 2칸씩 확인해야 하기 때문에 처음 2개와 마지막 2개는 제외
            for(int i=2; i<N-2; i++) {
                // 현재 건물을 제외한 주변 4개 중 최대 높이
                int max = Math.max(height[i-2], Math.max(height[i-1], Math.max(height[i+1], height[i+2])));

                // 현재 건물이 주변 모든 건물보다 높다면
                if(height[i] > max) answer += height[i] - max;
            }

            System.out.println("#" + t + " " + answer);
        }
    }
}