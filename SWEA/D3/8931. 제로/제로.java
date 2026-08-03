import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int K = Integer.parseInt(br.readLine());

            Stack<Integer> stack = new Stack<>();

            for(int k=0; k<K; k++) {
                int num = Integer.parseInt(br.readLine());
                
                if(num == 0) stack.pop();
                else stack.add(num);
            }
            
            int answer = 0;
            while(!stack.isEmpty()) {
                int num = stack.pop();
                
                answer += num;
            }

            System.out.println("#" + t + " " + answer);
        }
    }
}