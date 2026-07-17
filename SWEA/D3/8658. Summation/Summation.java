import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			
			for(int i=0; i<10; i++) {
				String num = st.nextToken();
				
				int sum = 0;
				for(int j=0; j<num.length(); j++) {
					sum += num.charAt(j) - '0';
				}
				
				max = Math.max(max, sum);
				min = Math.min(min, sum);
			}
			
			System.out.println("#" + t + " " + max + " " + min);
		}
	}
}