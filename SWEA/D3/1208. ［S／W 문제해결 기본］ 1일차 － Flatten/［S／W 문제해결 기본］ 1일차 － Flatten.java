import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=10; t++) {
            int chance = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            // 100개의 상자 높이
            int[] boxes =  new int[100];

            for(int i=0; i<100; i++) {
                boxes[i] = Integer.parseInt(st.nextToken());
            }

            for(int dump=0; dump<chance; dump++) {
                int maxIdx = 0;
                int minIdx = 0;

                // 현재 가장 높은 곳, 낮은 곳 찾기
                for(int i=0; i<100; i++) {
                    if(boxes[i] > boxes[maxIdx]) maxIdx = i;
                    if(boxes[i] < boxes[minIdx]) minIdx = i;
                }

                // 이미 평탄화되었으면 종료
                if (boxes[maxIdx] - boxes[minIdx] <= 1) {
                    break;
                }
                boxes[maxIdx]--;
                boxes[minIdx]++;
            }
            // 덤프가 끝난 후 최댓값 / 최솟값 다시 찾기
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < 100; i++) {
                max = Math.max(max, boxes[i]);
                min = Math.min(min, boxes[i]);
            }

            System.out.println("#" + t + " " + (max - min));
        }
    }
}