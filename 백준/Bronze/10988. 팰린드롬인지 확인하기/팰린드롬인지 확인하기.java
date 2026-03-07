import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String line = sc.next();
		
		boolean possible = true;
		for(int i=0; i<=line.length()/2; i++) {
			if(line.charAt(i) != line.charAt(line.length()-1-i)) {
				possible = false;
				break;
			}
		}
		
		if(possible) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}