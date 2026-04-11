import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			
			char[][] chess = new char[8][8];
			
			boolean possible = true; 
			
			for(int i=0; i<8; i++) {
				int cnt = 0;
				
				String line = br.readLine();
				for(int j=0; j<8; j++) {
					char rook = line.charAt(j);
					if(rook == 'O') cnt++;

					chess[i][j] = rook;
				}
				
				if(cnt != 1) {
			        possible = false;
			    }
			}
			
			if(possible) {
				for(int j=0; j<8; j++) {
					int cnt = 0;
					for(int i=0; i<8; i++) {
						if(chess[i][j] == 'O') cnt++;
					}
					
					if(cnt != 1) {
			            possible = false;
			        }
				}
			}
			
			if(possible) System.out.println("#" + t + " yes");
			else System.out.println("#" + t + " no");
		}
	}
}