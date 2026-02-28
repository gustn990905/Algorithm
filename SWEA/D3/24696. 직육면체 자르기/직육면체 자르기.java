import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int t = 1; t <= T; t++) {

            long A = sc.nextLong();
            long B = sc.nextLong();
            long C = sc.nextLong();

            long total = A * B * C - 1;

            if(total % 2 == 1) {
                System.out.println(1);  // 선공 승
            } else {
                System.out.println(2);  // 후공 승
            }
        }
    }
}