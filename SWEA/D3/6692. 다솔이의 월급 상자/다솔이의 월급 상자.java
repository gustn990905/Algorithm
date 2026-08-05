import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            double answer = 0.0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st =
                        new StringTokenizer(br.readLine());

                double p = Double.parseDouble(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                answer += p * x;
            }

            System.out.printf("#%d %.6f%n", tc, answer);
        }
    }
}