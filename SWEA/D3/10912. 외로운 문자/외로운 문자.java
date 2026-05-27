import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			String N = sc.next();
			
			// true면 짝이 있는 숫자, false면 짝이 없는 숫자
			boolean[] check = new boolean[N.length()];
			
			for(int i=0; i<N.length()-1; i++) {
				if(!check[i]) {
					char target = N.charAt(i);
					for(int j=i+1; j<N.length(); j++) {
						if(target == N.charAt(j) && !check[j]) {
							check[i] = true;
							check[j] = true;
							break;
						}
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<N.length(); i++) {
				if(check[i]) continue;
				else sb.append(N.charAt(i));
			}
			
			if(sb.length() == 0) System.out.println("#" + t + " Good");
			else {
				char[] arr = sb.toString().toCharArray();
				Arrays.sort(arr);
				sb = new StringBuilder(new String(arr));
				System.out.println("#" + t + " " + sb);
			}
		}
	}
}