import java.util.Scanner;

class Solution {

    // 팰린드롬 판별 함수
    static boolean isPalindrome(String s) {

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {

            int A = sc.nextInt();
            int B = sc.nextInt();

            int cnt = 0;

            // 루트값 기준으로 탐색
            for (int n = 1; n * n <= B; n++) {

                int square = n * n;

                // 범위 밖이면 건너뛰기
                if (square < A) continue;

                String num = String.valueOf(n);
                String sq = String.valueOf(square);

                // n과 n² 둘 다 팰린드롬이면 카운트
                if (isPalindrome(num) && isPalindrome(sq)) {
                    cnt++;
                }
            }

            System.out.println("#" + t + " " + cnt);
        }
    }
}