import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int minNum = Integer.MAX_VALUE;
		
		minNum = Math.min(Math.min(Math.abs(x-0), Math.abs(y-0)), Math.min(Math.abs(x-w), Math.abs(y-h)));
		
		System.out.println(minNum);
	}
}