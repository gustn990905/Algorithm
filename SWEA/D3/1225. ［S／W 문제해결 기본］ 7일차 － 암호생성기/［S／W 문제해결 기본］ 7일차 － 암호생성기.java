import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=10; t++) {
            // 테스트 케이스 번호를 먼저 입력받음
            int testCase = Integer.parseInt(br.readLine());
            
            StringTokenizer st = new StringTokenizer(br.readLine());

            Queue<Integer> q = new ArrayDeque<>();

            for(int i=0; i<8; i++) {
                q.add(Integer.parseInt(st.nextToken()));
            }

            boolean finish = false;
            while(!finish) {
                for(int decrease=1; decrease<=5; decrease++) {
                    int num = q.poll();

                    num -= decrease;

                    if(num <= 0) {
                        num = 0;
                        finish = true;
                    }

                    q.add(num);

                    if(finish) break;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t);

            while (!q.isEmpty()) {
                sb.append(" ").append(q.poll());
            }

            System.out.println(sb);
        }
    }
}