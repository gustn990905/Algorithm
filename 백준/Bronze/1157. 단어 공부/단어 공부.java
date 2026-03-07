import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String line = sc.next();
		int[] check = new int[26];
		
		String upperLine = line.toUpperCase();
		
		for(int i=0; i<upperLine.length(); i++) {
			check[upperLine.charAt(i)-'A']++;
		}
		
		int maxNum = 0;
		for(int i=0; i<26; i++) {
			maxNum = Math.max(maxNum, check[i]);
		}
		
		int checkNum = 0;
		int checkIdx = 0;
		for(int i=0; i<26; i++) {
			if(maxNum == check[i]) {
				checkNum++;
				checkIdx = i;
			}
		}
		
		if(checkNum == 1) {
			System.out.println((char)(checkIdx + 'A'));
		} else {
			System.out.println("?");
		}
	}
}