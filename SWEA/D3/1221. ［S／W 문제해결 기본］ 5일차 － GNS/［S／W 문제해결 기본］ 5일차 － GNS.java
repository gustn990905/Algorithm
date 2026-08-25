import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

class Solution{
    public static void main(String[] args) throws IOException {
        String[] nums = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<10; i++) {
            map.put(nums[i], i);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();

            int cnt = Integer.parseInt(st.nextToken());

            int[] count = new int[10];

            st = new StringTokenizer(br.readLine());
            for(int c=0; c<cnt; c++) {
                String now = st.nextToken();

                int num = map.get(now);

                count[num]++;
            }

            System.out.println("#" + t);

            for(int i=0; i<10; i++) {
                for(int j=0; j<count[i]; j++) {
                    System.out.print(nums[i] + " ");
                }
            }
            System.out.println();
        }
    }
}