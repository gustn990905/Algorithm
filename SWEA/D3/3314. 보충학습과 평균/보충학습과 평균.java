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

            // 학생은 다섯 명
            int cnt = 0;
            for(int i=0; i<5; i++) {
                int score = Integer.parseInt(st.nextToken());

                if(score >= 40) cnt += score;
                else cnt += 40;
            }

            System.out.println("#" + t + " " + (cnt/5));
        }
    }
}