import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // N명의 참가자
            int M = Integer.parseInt(st.nextToken()); // M개의 문제

            // 각 사람 별 푼 문제의 수
            int[] cnt = new int[N];
            for(int n=0; n<N; n++) {
                st = new StringTokenizer(br.readLine());
                int count = 0; // 맞춘 문제 수
                for(int m=0; m<M; m++) {
                    int check = Integer.parseInt(st.nextToken());

                    if(check == 1) count++;
                }
                cnt[n] = count;
            }

            int max = 0;
            for(int i=0; i<N; i++) {
                max = Math.max(max, cnt[i]);
            }
            
            int people = 0;
            for(int i=0; i<N; i++) {
                if(cnt[i] == max) people++;
            }

            System.out.println("#" + t + " " + people + " " + max);
        }
    }
}