import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int t=1; t<=T; t++) {
            int n = sc.nextInt();

            int h = n / 30;
            int m = (n % 30) * 2;

            System.out.println("#" + t + " " + h + " " + m);
        }
    }
}