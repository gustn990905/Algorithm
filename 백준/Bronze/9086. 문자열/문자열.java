import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			String line = sc.next();

			System.out.print(line.charAt(0));
			System.out.println(line.charAt(line.length()-1));
		}
	}
}