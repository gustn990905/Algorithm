import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int T = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            result.append("#").append(tc).append(" ");

            for (int person = 1; person <= N; person++) {
                result.append("1/").append(N);

                if (person < N) {
                    result.append(" ");
                }
            }

            result.append("\n");
        }

        System.out.print(result);
    }
}