import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            if (N % 2 == 0) {
                sb.append(N + 4).append(" ").append(4).append("\n");
            } else {
                sb.append(N + 9).append(" ").append(9).append("\n");
            }
        }

        System.out.print(sb);
    }
}