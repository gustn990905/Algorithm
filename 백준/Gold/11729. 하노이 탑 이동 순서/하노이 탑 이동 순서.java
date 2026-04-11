import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long count = 1;
        for(int i = 0; i < N; i++) {
            count *= 2;
        }
        count -= 1;

        System.out.println(count);

        hanoi(N, 1, 2, 3);

        System.out.print(sb);
    }

    static void hanoi(int n, int from, int via, int to) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        hanoi(n - 1, from, to, via);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(n - 1, via, from, to);
    }
}