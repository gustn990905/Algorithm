import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=10; t++) {
            int N = Integer.parseInt(br.readLine());

            LinkedList<Integer> list = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());;
            for(int n=0; n<N; n++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<K; k++) {
                String command = st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                for(int i=0; i<y; i++) {
                    int num = Integer.parseInt(st.nextToken());
                    list.add(x+i, num);
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");

            for(int i=0; i<10; i++) {
                sb.append(list.get(i)).append(" ");
            }

            System.out.println(sb);
        }
    }
}