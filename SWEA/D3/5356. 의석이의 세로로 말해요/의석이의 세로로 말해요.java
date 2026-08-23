import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            String[] s = new String[5];
            int max = 0;
            for(int i=0; i<5; i++) {
                s[i] = br.readLine();
                max = Math.max(max, s[i].length());
            }

            StringBuilder sb = new StringBuilder();

            sb.append("#").append(t).append(" ");

            for(int i=0; i<max; i++) {
                for(int j=0; j<5; j++) {
                    if(s[j].length() > i) {
                        sb.append(s[j].charAt(i));
                    }
                }
            }

            System.out.println(sb);
        }
    }
}