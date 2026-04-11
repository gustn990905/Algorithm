import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		String answer = "abcdefghijklmnopqrstuvwxyz"; // 정확한 목록과 순서
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim()); // 테스트 케이스 수
		
		for(int t=1; t<=T; t++) {
			String line = br.readLine().trim();
			
			int result = 0;
			for(int i=0; i<line.length(); i++) {
				if(answer.charAt(i) == line.charAt(i))result++;
				else break; // 하나라도 다르면 중단
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}