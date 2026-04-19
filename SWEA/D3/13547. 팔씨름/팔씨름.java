import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			String game = br.readLine();
			
			int cntO = 0;
			int cntX = 0;
			
			int gameSum = 0; // 지금까지 진행한 경기수
			
			for(int i=0; i<game.length(); i++) {
				if(game.charAt(i) == 'o') cntO++; // 소정이가 이긴 횟수
				else cntX++; // 소정이가 진 횟수
			}
			
			gameSum = cntO + cntX;
			
			// 이겨야 하는 횟수보다 남은 경기가 더 많은 경우 YES 출력
			if(15-gameSum >= 8-cntO) System.out.println("#" + t + " YES");
			else System.out.println("#" + t + " NO");
		}
	}
}