import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for(int i=1; i<=N; i++) {
			String num = String.valueOf(i);
			
			// 3, 6, 9를 포함하지 않는 경우
			if(!num.contains("3") && !num.contains("6") && !num.contains("9")) {
				sb.append(i).append(" ");
			}
			
			// 3, 6, 9를 포함하는 경우
			else {
				int cnt = 0;
				for(int j=0; j<num.length(); j++) {
					if(num.charAt(j) == '3' || num.charAt(j) == '6' || num.charAt(j) == '9') {
						cnt++;
					}
				}
				
				for(int k=0; k<cnt; k++) {
					sb.append("-");
				}
				sb.append(" ");
			}
		}
		
		System.out.println(sb);
	}
}