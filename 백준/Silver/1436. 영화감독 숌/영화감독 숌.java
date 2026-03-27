import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
	
		int idx = 0;
		
		for(int i=666; i<=6660000; i++) {
			String num = String.valueOf(i); 
			boolean possible = false;

			for(int j=0; j<num.length(); j++) {
				if(num.contains("666")) {
					possible = true;
					break;
				}
			} 
			
			if(possible) idx++;
			
			if(idx==N) {
				System.out.println(i);
				break;
			}
		}
	}
}