import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean go = true;
		
		while(go) {
			
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			if(A == 0) {
				go = false;
			} else {
				System.out.println(A+B);
			}
		}
	}
}