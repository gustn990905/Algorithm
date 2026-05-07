import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); 
		
		for(int t=1; t<=T; t++) {
			String people = sc.next();
			
			int cnt = 0; // 결과
			int clap = people.charAt(0) - '0';
			
			for(int i=1; i<people.length(); i++) {
				if(people.charAt(i) == '0') continue;
				
				// 충분한 사람이 박수를 치고 있어서 고용할 필요가 없는 경우
				if(clap >= i) clap += people.charAt(i)-'0';
				
				// 고용해야하는 경우
				else {
					cnt += (i-clap);
					clap += (i-clap);
					clap += people.charAt(i) - '0';
				}
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
}