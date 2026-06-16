import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			String X = sc.next();
			
			boolean[] arr = new boolean[10];
			
			for(int x=0; x<X.length(); x++) {
				if(!arr[X.charAt(x) - '0']) arr[X.charAt(x) - '0'] = true;
			}
			
			int cnt = 0;
			for(int i=0; i<10; i++) {
				if(arr[i]) cnt++;
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
}