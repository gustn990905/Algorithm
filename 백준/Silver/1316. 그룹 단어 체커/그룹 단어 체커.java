import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int cnt = 0;
		for(int t=0; t<T; t++) {
			boolean[] check = new boolean[26];
			boolean possible = true;
			
			String line = sc.next();
			
			check[line.charAt(0)-'a'] = true;
			for(int i=1; i<line.length(); i++) {

			    if(line.charAt(i) != line.charAt(i-1)) {
			        if(check[line.charAt(i)-'a']) {
			            possible = false;
			            break;
			        }
			    }

			    check[line.charAt(i)-'a'] = true;
			}
			
			if(possible) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}