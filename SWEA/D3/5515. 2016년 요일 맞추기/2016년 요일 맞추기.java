import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] day = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int cnt = d;
            for(int i=0; i<m-1; i++) {
                cnt += day[i];
            }

            cnt %= 7;
            cnt += 3; // 시작이 금요일

            if(cnt > 6) cnt -= 7;

            System.out.println("#" + t + " " + cnt);
        }
    }
}