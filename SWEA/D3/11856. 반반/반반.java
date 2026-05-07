import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); 
		
		for(int t=1; t<=T; t++) {
			String word = sc.next(); // 단어 입력 받기
			
			char[] list = new char[4];
			
			for(int i=0; i<4; i++) {
				list[i] = word.charAt(i);
			}
			
			Arrays.sort(list);
			
			if(list[0] == list[1] && list[2] == list[3] && list[1] != list[2]){
				System.out.println("#" + t + " Yes");
			} else System.out.println("#" + t + " No");
		}
	}
}
