import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int answer = 0;

            // S가 같은 연도만 검사
            for (int year = S; year <= 254040; year += 365) {

                int earth = (year - 1) % 24 + 1;
                int moon = (year - 1) % 29 + 1;

                if (earth == E && moon == M) {
                    answer = year;
                    break;
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}