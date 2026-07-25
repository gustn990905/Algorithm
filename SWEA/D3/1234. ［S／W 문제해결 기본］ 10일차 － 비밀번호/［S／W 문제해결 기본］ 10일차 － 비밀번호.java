import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int n = sc.nextInt();
            String s = sc.next();

            StringBuilder stack = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (stack.length() > 0 && stack.charAt(stack.length() - 1) == c) {
                    // 맨 위 문자와 같으면 짝 소거 (마지막 문자 제거)
                    stack.deleteCharAt(stack.length() - 1);
                } else {
                    stack.append(c);
                }
            }

            System.out.println("#" + tc + " " + stack.toString());
        }
    }
}