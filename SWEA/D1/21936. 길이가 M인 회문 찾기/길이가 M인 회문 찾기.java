import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			String line = sc.next();
			
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<=N-M; i++) {
				boolean go = true;
				for(int j=0; j<=M/2; j++) {
					if(line.charAt(i+j) != line.charAt(i+M-1-j)) {
						go = false;
						break;
					}
				}
				
				if(go) {
					for(int k=i; k<i+M; k++) {
						sb.append(line.charAt(k));
					}
				}
			}
			
			if(sb.length()==0) System.out.println("#" + t + " NONE");
			else System.out.println("#" + t + " " + sb);
		}
	}
}