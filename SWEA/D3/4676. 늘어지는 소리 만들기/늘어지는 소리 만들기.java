import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            String str = br.readLine();

            int H = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] hyphen = new int[str.length()+1];

            for(int i=0; i<H; i++) {
                int position = Integer.parseInt(st.nextToken());

                hyphen[position]++;
            }

            StringBuilder sb = new StringBuilder();

            for(int i=0; i<str.length(); i++) {
                // 해당 위치의 - 추가
                for(int j=0; j<hyphen[i]; j++) {
                    sb.append("-");
                }

                // 원래 문자 추가
                sb.append(str.charAt(i));
            }

            // 문자열 맨 뒤에 들어가는 -
            for(int j=0; j<hyphen[str.length()]; j++) {
                sb.append("-");
            }

            System.out.println("#" + t + " " + sb);
        }
    }
}