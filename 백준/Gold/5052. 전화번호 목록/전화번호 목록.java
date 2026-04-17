import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			String[] phoneNumber = new String[N];
			
			boolean possible = true;
			
			for(int n=0; n<N; n++) {
				
				// 공백을 제거하고 번호 저장
				String num = br.readLine().replace(" ", "");
				
				phoneNumber[n] = num;
			}
			
			Arrays.sort(phoneNumber);
			
			// 길이가 짧은 번호가 길이가 긴 번호에 포함되는지 확인
			for(int i=0; i<N-1; i++) {
					if(phoneNumber[i+1].startsWith(phoneNumber[i])) {
						possible = false;
						break;
					}
			}
						
			if(possible) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}