import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] answer = {1, 1, 2, 2, 2, 8};
		
		int[] dong = new int[6];
		
		for(int i=0; i<6; i++) {
			dong[i] = sc.nextInt();
			
			System.out.print((answer[i] - dong[i]) + " ");
		}
	}
}