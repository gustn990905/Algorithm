import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] scores = new int[N];

            st = new StringTokenizer(br.readLine());

            // N개의 점수 저장
            for(int i=0; i<N; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
            }

            // 정렬
            Arrays.sort(scores);

            int answer = 0;

            for(int k=N-K; k<N; k++) {
                answer += scores[k];
            }

            System.out.println("#" + t + " " + answer) ;
        }
    }
}