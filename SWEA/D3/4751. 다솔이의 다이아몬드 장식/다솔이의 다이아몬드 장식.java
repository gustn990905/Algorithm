import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t=1; t<=T; t++) {
            String word = sc.next();

            int width = word.length() * 4 + 1;
            char[][] board = new char[5][width];

            // 처음에는 모든 칸을 .으로 채우기
            for(int r=0; r<5; r++) {
                Arrays.fill(board[r], '.');
            }

            // 각 문자마다 다이아몬드 장식 만들기
            for(int i=0; i<word.length(); i++) {
                int center = 2 + i*4;

                board[0][center] = '#';

                board[1][center-1] = '#';
                board[1][center+1] = '#';

                board[2][center - 2] = '#';
                board[2][center] = word.charAt(i);
                board[2][center + 2] = '#';

                board[3][center - 1] = '#';
                board[3][center + 1] = '#';

                board[4][center] = '#';
            }

            // 완성된 장식 출력
            for (int r = 0; r < 5; r++) {
                System.out.println(new String(board[r]));
            }
        }
    }
}