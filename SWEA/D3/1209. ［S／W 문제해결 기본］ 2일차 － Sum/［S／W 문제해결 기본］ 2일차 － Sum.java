import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=10; t++) {
            int testCase = Integer.parseInt(br.readLine());
            
            int[][] map = new int[100][100];

            int max = 0;
            for(int r=0; r<100; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for(int c=0; c<100; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < 100; i++) {
                int rowSum = 0;
                int colSum = 0;

                for (int j = 0; j < 100; j++) {
                    rowSum += map[i][j];  // i번째 행
                    colSum += map[j][i];  // i번째 열
                }

                max = Math.max(max, rowSum);
                max = Math.max(max, colSum);
            }

            int diagonal1 = 0;
            int diagonal2 = 0;

            for (int i = 0; i < 100; i++) {
                diagonal1 += map[i][i];
                diagonal2 += map[i][99 - i];
            }

            max = Math.max(max, diagonal1);
            max = Math.max(max, diagonal2);

            System.out.println("#" + t + " " + max);
        }
    }
}