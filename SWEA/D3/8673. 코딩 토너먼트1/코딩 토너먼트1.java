import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int K = Integer.parseInt(br.readLine());

            int size = (int) Math.pow(2, K);

            int[] players = new int[size];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=0; i<size; i++){
                players[i] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;

            // 참가자가 한 명 남을 때까지 진행
            while(size > 1) {
                int[] winners = new int[size / 2];

                for (int i = 0; i < size; i += 2) {
                    int first = players[i];
                    int second = players[i + 1];

                    // 실력 차이 누적
                    answer += Math.abs(first - second);

                    // 실력이 높은 선수가 다음 라운드 진출
                    winners[i / 2] = Math.max(first, second);
                }

                // 다음 라운드 참가자 배열로 변경
                players = winners;
                size /= 2;
            }
            System.out.println("#" + t + " " + answer);
        }
    }
}