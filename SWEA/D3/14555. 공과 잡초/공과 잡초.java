import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			String line = sc.next();
			
			int ball = 0;
			int grass = 0;
			for(int i=0; i<line.length(); i++) {
				if(line.charAt(i) == '(') {
					ball++;
					grass = 0;
				}
				
				else if(line.charAt(i) == '|') {
					grass++;
				}
				
				else if(line.charAt(i) == ')'){
					if(grass > 0) {
						ball++;
						grass = 0;
					} else {
						continue;
					}
				} 
				
				else continue;
			}
			
			System.out.println("#" + t + " " + ball);
		}
	}
}