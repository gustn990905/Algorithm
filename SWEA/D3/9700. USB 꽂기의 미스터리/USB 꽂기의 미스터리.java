import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            double p = Double.parseDouble(st.nextToken());
            double q = Double.parseDouble(st.nextToken());

            // 정확히 한 번 뒤집은 후 성공할 확률
            double s1 = (1 - p) * q;

            // 정확히 두 번 뒤집은 후 성공할 확률
            double s2 = p * (1 - q) * q;

            String answer;

            if (s1 < s2) {
                answer = "YES";
            } else {
                answer = "NO";
            }

            System.out.println("#" + t + " " + answer);
        }
    }
}