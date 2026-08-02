import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            boolean[] num = new boolean[10];
            
            String line = br.readLine();
            
            for(int l=0; l<line.length(); l++) {
                int target = line.charAt(l) -'0';
                
                if(num[target]) num[target] = false;
                else num[target] = true;
            }
            
            int answer = 0;
            for(int i=0; i<10; i++) {
                if(num[i]) answer++;
            }

            System.out.println("#" + t + " " + answer);
        }
    }
}