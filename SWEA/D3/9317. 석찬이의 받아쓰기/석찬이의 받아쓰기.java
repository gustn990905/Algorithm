import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			char[] correct = new char[N];
			String line1 = br.readLine();
			for(int i=0; i<N; i++) {
				correct[i] = line1.charAt(i);
			}
			
			char[] answer = new char[N];
			String line2 = br.readLine();
			for(int i=0; i<N; i++) {
				answer[i] = line2.charAt(i);
			}
			
			int cnt = 0;
			for(int i=0; i<N; i++) {
				if(correct[i] != answer[i]) continue;
				else cnt++;
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
}