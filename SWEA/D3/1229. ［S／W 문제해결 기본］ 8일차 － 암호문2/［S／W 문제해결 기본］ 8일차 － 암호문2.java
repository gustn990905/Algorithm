import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {

            // 원본 암호문 길이
            int N = Integer.parseInt(br.readLine());

            List<Integer> list = new ArrayList<>();

            // 원본 암호문
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            // 명령어 개수
            int M = Integer.parseInt(br.readLine());

            // 명령어 한 줄
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {

                String command = st.nextToken();

                if (command.equals("I")) {

                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    for (int j = 0; j < y; j++) {
                        int value = Integer.parseInt(st.nextToken());

                        list.add(x + j, value);
                    }

                } else if (command.equals("D")) {

                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    for (int j = 0; j < y; j++) {
                        list.remove(x);
                    }
                }
            }

            System.out.print("#" + tc);

            for (int i = 0; i < 10; i++) {
                System.out.print(" " + list.get(i));
            }

            System.out.println();
        }
    }
}