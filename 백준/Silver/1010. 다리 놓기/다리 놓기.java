import java.util.Scanner;

public class Main {

    static long comb(int n, int r) {
        if (r > n - r) r = n - r;

        long result = 1;

        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            System.out.println(comb(M, N));
        }
    }
}