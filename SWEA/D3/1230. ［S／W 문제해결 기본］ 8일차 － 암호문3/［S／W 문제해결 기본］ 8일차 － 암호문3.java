import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=10; t++) {
            int N = Integer.parseInt(br.readLine()); // 암호문의 개수

            ArrayList<Integer> words = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                words.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for(int i=0; i<M; i++) {
                String command = st.nextToken();

                // 삽입 처리
                if (command.equals("I")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    for(int j=0; j<y; j++) {
                        int s = Integer.parseInt(st.nextToken());
                        words.add(x+j, s);
                    }
                }

                // 삭제 처리
                else if (command.equals("D")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    for(int j=0; j<y; j++) {
                        words.remove(x);
                    }
                }

                // 추가 처리
                else if (command.equals("A")) {
                    int y = Integer.parseInt(st.nextToken());

                    for(int j=0; j<y; j++) {
                        int s = Integer.parseInt(st.nextToken());
                        words.add(s);
                    }
                }
            }

            System.out.print("#" + t + " ");
            for(int i=0; i<10; i++) {
                System.out.print(words.get(i) + " ");
            }
            System.out.println();
        }
    }
}