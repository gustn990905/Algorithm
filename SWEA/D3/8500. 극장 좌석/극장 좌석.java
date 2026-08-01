import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] people = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int n=0; n<N; n++) {
                people[n] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(people);

            int answer = 0;

            for(int n=0; n<N; n++) {
                answer += people[n] + 1;
            }
            
            answer += people[N-1];

            System.out.println("#" + t + " " + answer);
        }
    }
}