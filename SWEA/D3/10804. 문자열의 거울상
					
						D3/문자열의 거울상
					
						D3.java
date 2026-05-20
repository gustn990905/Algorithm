import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			String line = sc.next();
			
			StringBuilder answer = new StringBuilder();
			
			for(int i=line.length()-1; i>=0; i--) {
				char target = line.charAt(i);
				
				if(target == 'b') answer.append('d');
				else if(target == 'd') answer.append('b');
				else if(target == 'p') answer.append('q');
				else answer.append('p');
			}
			
			System.out.println("#" + t + " " + answer.toString());
		}
	}
}