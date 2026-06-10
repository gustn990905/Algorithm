import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int up = 0;
			int down = 0;
			for(int i=0; i<N-1; i++) {
				int before = arr[i];
				int after = arr[i+1];
				
				// 높이가 같으면 pass
				if(before == after) continue;
				
				// 오르막
				else if(before < after) up = Math.max(up, after - before);
				
				// 내리막
				else down = Math.max(down, before - after);
			}
			System.out.println("#" + t + " " + up + " " + down);
		}
	}
}