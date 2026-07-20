import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=10; t++) {
            // 입력으로 주어지는 테스트케이스 번호
            int testCase = Integer.parseInt(br.readLine());

            int[][] board = new int[100][100];

            for(int i=0; i<100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            // 붉은 자성체 밑에 푸른 자성체가 있으면 교착 상태
            for(int j=0; j<100; j++) {
                boolean cross = false; // 교착 상태 여부
                for(int i=0; i<100; i++) {
                    // 0이면 자석이 없음
                    if(board[i][j] == 0) continue;

                    // 뷹은 자성체(1)을 만나면 S극으로 이끌림
                    else if(!cross && board[i][j] == 1) {
                        // 교착 확률 생김
                        cross = true;
                    }

                    // 교착 확률이 있는 상태로 푸른 자성체 만남
                    else if(cross && board[i][j] == 2) {
                        cnt++;
                        cross = false;
                    }
                }
            }
            System.out.println("#" + t + " " + cnt);
        }
    }
}