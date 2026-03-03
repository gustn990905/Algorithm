import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[26];
		
		for(int i=0; i<26; i++) {
			arr[i] = -1;
		}
		
		String line = sc.next();
		
		for(int i=0; i<line.length(); i++) {
			if(arr[line.charAt(i)-'a'] == -1) {
				arr[line.charAt(i) - 'a'] = i;
			}
		}
		
		for(int i=0; i<26; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}