import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			String P = sc.next().trim();
			String Q = sc.next().trim();
			
			int pSize = P.length();
			int qSize = Q.length();
			
			// 길이 차가 1이고
			if(qSize - pSize == 1) {
				
				// 앞부분이 모두 같고
				boolean possible = true;
				for(int i=0; i<pSize; i++) {
					if(P.charAt(i) != Q.charAt(i)) possible = false;
				}
				
				if(possible) {
					// 마지막 문자가 a인 경우 -> No
					if(Q.charAt(qSize-1) == 'a') System.out.println("#" + t + " N");
					else System.out.println("#" + t + " Y");
				} else System.out.println("#" + t + " Y");
			}
			// 그 외 -> Yes
			else System.out.println("#" + t + " Y");
		}
	}
}