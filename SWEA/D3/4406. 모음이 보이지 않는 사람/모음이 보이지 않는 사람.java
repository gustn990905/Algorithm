import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String pass = "aeiou";
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			String line = sc.next();
			
			String answer = "";
			for(int i=0; i<line.length(); i++) {
				if(pass.contains(String.valueOf(line.charAt(i)))) continue;
				
				answer += line.charAt(i);
			}
			
			System.out.println("#" + t + " " + answer);
		}
	}
}